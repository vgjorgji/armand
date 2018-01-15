package com.armand.cms.core.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the OneOf validator.
 */
public class OneOfValidator implements ConstraintValidator<OneOf, Object> {

  private List<String> values;

  @Override
  public void initialize(final OneOf constraintAnnotation) {
    String[] temp = constraintAnnotation.values();
    values = new ArrayList<>(temp.length);
    Arrays.stream(temp).forEach(value -> values.add(value.toLowerCase()));
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    String temp = null;
    if (value != null) {
      temp = value.toString().toLowerCase();
    }
    return values.contains(temp);
  }
}
