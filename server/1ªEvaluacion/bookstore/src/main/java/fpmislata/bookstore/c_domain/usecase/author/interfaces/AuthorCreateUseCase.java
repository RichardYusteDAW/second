package fpmislata.bookstore.c_domain.usecase.author.interfaces;

public interface AuthorCreateUseCase {

    Integer execute(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
            Integer deathYear);
}