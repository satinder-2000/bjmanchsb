package org.bjm.security;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface PasswordMatch {

    String message() default "Password and Confirm Password do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

