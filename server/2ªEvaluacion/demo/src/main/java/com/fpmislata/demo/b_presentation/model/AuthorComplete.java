package com.fpmislata.demo.b_presentation.model;

import com.fpmislata.demo.a_common.annotation.DeathYear;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@DeathYear
public record AuthorComplete(
                Integer id,
                @NotBlank String name,
                @NotBlank String nationality,
                @NotBlank String biographyEs,
                @NotBlank String biographyEn,
                @NotNull @Min(1) Integer birthYear,
                @NotNull @Min(1) Integer deathYear) {
}