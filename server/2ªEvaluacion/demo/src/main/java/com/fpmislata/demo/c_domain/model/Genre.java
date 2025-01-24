package com.fpmislata.demo.c_domain.model;

import com.fpmislata.demo.a_common.locale.LanguageUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    private Integer id;
    private String nameEs;
    private String nameEn;
    private String slug;

    public String getName() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return nameEn;
        }
        return nameEs;
    }
}