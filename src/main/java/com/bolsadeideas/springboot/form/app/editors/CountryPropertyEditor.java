package com.bolsadeideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import com.bolsadeideas.springboot.form.app.services.CountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {
	
	@Autowired
	private CountryService countryService;
	
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		if(id != null && !StringUtils.isEmptyOrWhitespace(id)) {
			try {
				this.setValue(countryService.getById(Integer.parseInt(id)));
			} catch (NumberFormatException e) {
				setValue(null);
			}
		}else {
			setValue(null);
		}
	}
	
}
