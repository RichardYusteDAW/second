package com.fpmislata.demo.b_presentation.model;

import jakarta.validation.constraints.NotBlank;

public record GenreComplete(
        Integer id,
        @NotBlank String nameEs,
        @NotBlank String nameEn,
        @NotBlank String slug) {
}