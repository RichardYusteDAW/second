package com.fpmislata.demo.c_domain.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String slug;
}