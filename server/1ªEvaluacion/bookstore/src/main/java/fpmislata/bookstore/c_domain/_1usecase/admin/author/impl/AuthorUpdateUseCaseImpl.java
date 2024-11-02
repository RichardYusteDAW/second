package fpmislata.bookstore.c_domain._1usecase.admin.author.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorUpdateUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;

@Component
@AllArgsConstructor
public class AuthorUpdateUseCaseImpl implements AuthorUpdateUseCase {

    private final AuthorService authorService;

    @Override
    public Boolean execute(Integer id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {
        return authorService.update(id, name, nationality, biographyEs, biographyEn, birthYear, deathYear);
    }
}