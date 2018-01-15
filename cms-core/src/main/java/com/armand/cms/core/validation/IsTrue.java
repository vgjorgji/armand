package com.armand.cms.core.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation annotation to validate that the field's value is TRUE.
 * Example:
 * IsTrue(message = "The value must be TRUE")
 */
@Target({FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsTrueValidator.class)
@Documented
public @interface IsTrue {

	String message() default "The value must be TRUE";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several <code>@IsTrue</code> annotations on the same element.
	 *
	 * @see IsTrue
	 */
	@Target({FIELD, ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List {
		IsTrue[] value();
	}
}
