package com.vcms.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation annotation to validate that the field's value is not equal to the given value.
 * Example:
 * @NotEqual(value = "test", message = "The value must not be 'test'")
 *  
 * @author vlado.gjorgjiev
 */
@Target({FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotEqualValidator.class)
@Documented
public @interface NotEqual {
	
	String message() default "The field value is equal to configured value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The value to check with
	 */
	String value();

	/**
	 * Defines several <code>@NotEqual</code> annotations on the same element.
	 * 
	 * @see NotEqual
	 */
	@Target({FIELD, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		NotEqual[] value();
	}
}
