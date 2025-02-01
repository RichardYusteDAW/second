package com.fpmislata.demo.c_domain.model;

import com.fpmislata.demo.a_common.locale.LanguageUtils;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer id;
    private @NotBlank String nameEs;
    private @NotBlank String nameEn;
    private @NotBlank String slug;

    public String getName() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return nameEn;
        }
        return nameEs;
    }
}