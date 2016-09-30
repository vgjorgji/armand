package com.vcms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Implementation of the OneOf validator.
 * 
 * @author vlado.gjorgjiev
 */
public class OneOfValidator implements ConstraintValidator<OneOf, Object> {
	
	private String[] values;

	@Override
	public void initialize(final OneOf constraintAnnotation) {
		String[] temp = constraintAnnotation.values();
		values = new String[temp.length];
		for (int i = 0; i < temp.length; i++) {
			values[i] = temp[i].toLowerCase();
		}
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		String temp = null;
		if (value != null) {
			temp = value.toString().toLowerCase();
		}
		return ArrayUtils.contains(values, temp);
	}
}
