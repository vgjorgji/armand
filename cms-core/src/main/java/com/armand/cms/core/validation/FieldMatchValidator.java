package com.armand.cms.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the FieldMatch validator.
 */
@SuppressWarnings("unused")
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		try {
			final Object firstObj = null; //BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = null; //BeanUtils.getProperty(value, secondFieldName);

			return (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
		} catch (final Exception ignore) {
			// ignore
		}
		return true;
	}
}
