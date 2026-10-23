package org.bjm.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = MobileOrPhoneValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface RequireMobileOrPhone {

    String message() default
            "Either mobile number or phone number is required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
