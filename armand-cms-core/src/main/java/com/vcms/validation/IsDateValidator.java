package com.vcms.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the IsDate validator.
 * 
 * @author vlado.gjorgjiev
 */
public class IsDateValidator implements ConstraintValidator<IsDate, Object> {
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	@Override
	public void initialize(final IsDate constraintAnnotation) {
		// nothing
	}
	
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean result = true;
		if (value != null) {
			try {
				DATE_FORMAT.parse(value.toString());
			} catch (ParseException e) {
				result = false;
			}
		}
		return result;
	}

}
