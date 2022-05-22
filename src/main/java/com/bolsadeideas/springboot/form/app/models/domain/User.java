package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

import com.bolsadeideas.springboot.form.app.validators.RegexIdentificator;
import com.bolsadeideas.springboot.form.app.validators.Required;

public class User {

//	@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
	@RegexIdentificator()
	private String id;
//	@NotEmpty
	private String name;
//	@NotBlank
	@Required
	private String lastname;
	@NotBlank
	@Size(max = 8, min = 3)
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer account;
	@NotNull
	@FutureOrPresent
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@NotNull
	private Country country;
	@NotEmpty
	private List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
