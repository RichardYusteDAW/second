package com.fpmislata.demo.c_domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Figure {
    @NotNull
    Integer id;
    String name;
    String role;
    String description;
}