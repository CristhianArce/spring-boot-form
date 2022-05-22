package com.bolsadeideas.springboot.form.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexIdentificatorValidator implements ConstraintValidator<RegexIdentificator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {		
		return value.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}");
	}
}
