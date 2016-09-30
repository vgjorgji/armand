package com.vcms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * Implementation of the NotEqual validator.
 * 
 * @author vlado.gjorgjiev
 */
public class NotEqualValidator implements ConstraintValidator<NotEqual, Object> {
	
	private String value;

	@Override
	public void initialize(final NotEqual constraintAnnotation) {
		value = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		return !StringUtils.equals(this.value, (String) value);
	}
}
