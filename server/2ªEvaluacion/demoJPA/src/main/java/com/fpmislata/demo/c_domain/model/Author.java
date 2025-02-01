package com.fpmislata.demo.c_domain.model;

import com.fpmislata.demo.a_common.annotation.DeathYear;
import com.fpmislata.demo.a_common.locale.LanguageUtils;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DeathYear
public class Author {

    private Integer id;
    private @NotBlank String name;
    private @NotBlank String nationality;
    private @NotBlank String biographyEs;
    private @NotBlank String biographyEn;
    private @NotNull @Min(1) Integer birthYear;
    private @NotNull @Min(1) Integer deathYear;

    public String getBiography() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biographyEn;
        }
        return biographyEs;
    }
}