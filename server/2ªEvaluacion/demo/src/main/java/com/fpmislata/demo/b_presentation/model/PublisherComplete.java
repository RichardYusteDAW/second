package com.fpmislata.demo.b_presentation.model;

import jakarta.validation.constraints.NotBlank;

public record PublisherComplete(
        Integer id,
        @NotBlank String name,
        @NotBlank String slug) {
}