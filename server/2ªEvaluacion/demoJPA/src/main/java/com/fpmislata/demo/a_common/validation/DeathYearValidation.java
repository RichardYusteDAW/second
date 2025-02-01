package com.fpmislata.demo.a_common.validation;

import com.fpmislata.demo.a_common.annotation.DeathYear;
import com.fpmislata.demo.c_domain.model.Author;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DeathYearValidation implements ConstraintValidator<DeathYear, Author> {
    @Override
    public void initialize(DeathYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Author author, ConstraintValidatorContext context) {
        if (author.getBirthYear() == null || author.getDeathYear() == null) {
            return true;
        }

        return author.getDeathYear() >= author.getBirthYear();
    }
}