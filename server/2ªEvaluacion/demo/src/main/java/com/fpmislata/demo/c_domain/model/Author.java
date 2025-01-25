package com.fpmislata.demo.c_domain.model;

import com.fpmislata.demo.a_common.locale.LanguageUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Integer id;
    private String name;
    private String nationality;
    private String biographyEs;
    private String biographyEn;
    private Integer birthYear;
    private Integer deathYear;

    public String getBiography() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biographyEn;
        }
        return biographyEs;
    }
}