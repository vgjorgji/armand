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
 * Validation annotation to validate that the field's value is one of the given values.
 * Example:
 * @OneOf(values = {"test1", "test2"}, message = "The value must be 'test1' or 'test2'")
 *  
 * @author vlado.gjorgjiev
 */
@Target({FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = OneOfValidator.class)
@Documented
public @interface OneOf {
	
	String message() default "The field value must be one of configured values";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The values to check with
	 */
	String[] values();

	/**
	 * Defines several <code>@OneOf</code> annotations on the same element.
	 * 
	 * @see OneOf
	 */
	@Target({FIELD, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		OneOf[] value();
	}
}
