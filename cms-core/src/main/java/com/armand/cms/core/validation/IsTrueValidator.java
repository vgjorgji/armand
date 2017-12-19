package com.armand.cms.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the IsTrue validator.
 * 
 * @author vlado.gjorgjiev
 */
public class IsTrueValidator implements ConstraintValidator<IsTrue, Object> {
	
	@Override
	public void initialize(final IsTrue constraintAnnotation) {
		// nothing
	}
	
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		return Boolean.TRUE.equals(value);
	}

}
