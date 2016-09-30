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
 * Validation annotation to validate that the field's value is valid date and time.
 * Example:
 * @IsDateAndTime(message = "The value must be valid date and time")
 *  
 * @author vlado.gjorgjiev
 */
@Target({FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsDateAndTimeValidator.class)
@Documented
public @interface IsDateAndTime {
	
	String message() default "The value must be valid date and time";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several <code>@IsDateAndTime</code> annotations on the same element.
	 * 
	 * @see IsDateAndTime
	 */
	@Target({FIELD, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		IsDateAndTime[] value();
	}
}
