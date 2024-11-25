package fpmislata.bookstore.b_presentation.admin.model;

public record AuthorDetail(
                Long id,
                String name,
                String nationality,
                String biographyEs,
                String biographyEn,
                Integer birthYear,
                Integer deathYear) {
}