package com.fpmislata.demo.b_presentation.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookComplete(
        Integer id,
        @NotBlank String isbn,
        @NotBlank String titleEs,
        @NotBlank String titleEn,
        @NotBlank String synopsisEs,
        @NotBlank String synopsisEn,
        @NotNull @DecimalMin("0.01") BigDecimal price,
        @NotNull @DecimalMin("0.01") Float discount,
        @NotBlank String cover,
        @NotNull PublisherComplete publisher,
        @NotNull CategoryComplete category,
        @NotEmpty List<GenreComplete> genres,
        @NotEmpty List<AuthorComplete> authors) {
}