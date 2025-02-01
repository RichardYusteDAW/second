package com.fpmislata.demo.c_domain.model;

import java.math.BigDecimal;
import java.util.List;

import com.fpmislata.demo.a_common.locale.LanguageUtils;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private @NotBlank String isbn;
    private @NotBlank String titleEs;
    private @NotBlank String titleEn;
    private @NotBlank String synopsisEs;
    private @NotBlank String synopsisEn;
    private @NotNull @DecimalMin("0.01") BigDecimal price;
    private @NotNull @DecimalMin("0.01") Float discount;
    private @NotBlank String cover;
    private @NotNull Publisher publisher;
    private @NotNull Category category;
    private @NotEmpty List<Genre> genres;
    private @NotEmpty List<Author> authors;

    public String getTitle() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return titleEn;
        }
        return titleEs;
    }

    public String getSynopsis() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return synopsisEn;
        }
        return synopsisEs;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }
}