package com.fpmislata.demo.a_common.validation;

import com.fpmislata.demo.a_common.annotation.DeathYear;
import com.fpmislata.demo.b_presentation.model.AuthorComplete;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DeathYearValidation implements ConstraintValidator<DeathYear, AuthorComplete> {
    @Override
    public void initialize(DeathYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AuthorComplete authorComplete, ConstraintValidatorContext context) {
        return authorComplete.deathYear() > authorComplete.birthYear();
    }
}