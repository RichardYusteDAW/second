package fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces;

public interface AuthorUpdateUseCase {
    Boolean execute(Long id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear);
}
