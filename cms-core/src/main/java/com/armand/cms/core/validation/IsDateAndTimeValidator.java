package com.armand.cms.core.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the IsDate validator.
 */
public class IsDateAndTimeValidator implements ConstraintValidator<IsDate, Object> {

  private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");

  @Override
  public void initialize(final IsDate constraintAnnotation) {
    // nothing
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    boolean result = true;
    if (value != null) {
      try {
        DATE_TIME_FORMAT.parse(value.toString());
      } catch (ParseException e) {
        result = false;
      }
    }
    return result;
  }

}
