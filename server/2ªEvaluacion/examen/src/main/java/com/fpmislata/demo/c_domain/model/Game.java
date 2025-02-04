package com.fpmislata.demo.c_domain.model;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    Integer id;
    @NotBlank
    String gameCode;
    @NotBlank
    String title;
    @NotNull
    @Min(1)
    Integer releaseYear;
    @NotBlank
    String description;
    @NotNull
    Director director;
    @NotNull
    List<Figure> characters;
}