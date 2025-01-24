package com.fpmislata.demo.b_presentation.model;

import java.math.BigDecimal;
import java.util.List;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.Publisher;

public record BookComplete(
        Integer id,
        String isbn,
        String titleEs,
        String titleEn,
        String synopsisEs,
        String synopsisEn,
        BigDecimal price,
        float discount,
        String cover,
        Publisher publisher,
        Category category,
        List<Genre> genres,
        List<Author> authors) {
}