package fpmislata.bookstore.controller._1model;

public record AuthorDetail(
        long id,
        String name,
        String nationality,
        String biography,
        int birthYear,
        int deathYear) {
}