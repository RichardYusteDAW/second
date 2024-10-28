package fpmislata.bookstore.c_domain.usecase.author.interfaces;

public interface AuthorUpdateUseCase {
    Boolean execute(Integer id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear);
}
