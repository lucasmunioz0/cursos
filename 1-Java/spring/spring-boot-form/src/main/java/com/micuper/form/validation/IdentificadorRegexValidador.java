package com.micuper.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}");
	}
}
