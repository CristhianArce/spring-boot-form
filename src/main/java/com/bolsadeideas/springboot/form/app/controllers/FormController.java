package com.bolsadeideas.springboot.form.app.controllers;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.CountryPropertyEditor;
import com.bolsadeideas.springboot.form.app.editors.RolesEditor;
import com.bolsadeideas.springboot.form.app.editors.UppercaseNameEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Country;
import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.User;
import com.bolsadeideas.springboot.form.app.services.CountryService;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private CountryPropertyEditor countryPropertyEditor;
	
	@Autowired
	private RolesEditor rolesditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
		
		//Date Editor
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth",new CustomDateEditor(dateFormat, true));
		//Name Editor
		binder.registerCustomEditor(String.class, "name", new UppercaseNameEditor());
		//Country Editor
		binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
		//Role Editor
		binder.registerCustomEditor(Role.class, "roles", rolesditor);
	}
	
	@ModelAttribute("countries")
	public List<String> countries(){
		return Arrays.asList("Colombia", "México", "Argentina", "Perú", "Brasil", "España", "Chile", "Ecuador", "Venezuela");
	}
	
	@ModelAttribute("countriesMap")
	public Map<String, String> countriesMap(){
		Map<String, String> countryAndCode = new HashMap<String, String>();
		
		countryAndCode.put("Colombia", "CO");
		countryAndCode.put("México", "MX");
		countryAndCode.put("Argentina", "AR");
		countryAndCode.put( "Perú", "PE");
		countryAndCode.put("Brasil", "BR");
		countryAndCode.put("España", "ES");
		countryAndCode.put("Chile", "CL");
		countryAndCode.put("Ecuador", "EC");
		countryAndCode.put("Venezuela", "VZ");
		
		return countryAndCode;
	}
	
	@ModelAttribute("countriesList")
	public List<Country> countriesList(){
		return countryService.getAll();
	}
	
	@ModelAttribute("roles")
	public List<String> roles(){
		return Arrays.asList(
				"ROLE_ADMIN", 
				"ROLE_USER", 
				"ROLE_MODERATOR");
	}
	
	@ModelAttribute("rolesMap")
	public Map<String, String> rolesMap(){
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}
	
	
	@ModelAttribute("rolesList")
	public List<Role> rolesList(){
		return roleService.getAll();
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		System.out.println("Get Request");
		User user = new User();
		user.setName("Joe");
		user.setLastname("Doe");
		user.setId("XLR8");
		model.addAttribute("title", "Formulario de creación de usuarios");
		model.addAttribute("user", user);
		return "form";
	}
	
	
	@PostMapping("/form")
	public String processForm(Model model, @Valid User user, BindingResult result, SessionStatus status) {
//		userValidator.validate(user, result);
		model.addAttribute("title", "Formulario Post");
		if(result.hasErrors()) {
			return "form";
		}
		model.addAttribute("user", user);
		status.setComplete();
		return "result";
	}
	
}
