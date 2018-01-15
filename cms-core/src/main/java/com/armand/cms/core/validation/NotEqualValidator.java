package com.armand.cms.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the NotEqual validator.
 */
public class NotEqualValidator implements ConstraintValidator<NotEqual, Object> {

  private String value;

  @Override
  public void initialize(final NotEqual constraintAnnotation) {
    value = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    return this.value != null && this.value.equals((String) value);
  }
}
