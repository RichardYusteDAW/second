package fpmislata.bookstore.controller._1model;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String ISBN,
        String title,
        String synopsis,
        BigDecimal price,
        Float discount,
        String cover,
        Publisher publisher,
        Category category,
        List<Author> authorList,
        List<Genre> genreList) {
}