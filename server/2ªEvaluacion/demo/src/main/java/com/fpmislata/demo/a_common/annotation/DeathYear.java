package com.fpmislata.demo.a_common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fpmislata.demo.a_common.validation.DeathYearValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DeathYearValidation.class)
public @interface DeathYear {
    String message() default "The death year must be greater than birth year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}