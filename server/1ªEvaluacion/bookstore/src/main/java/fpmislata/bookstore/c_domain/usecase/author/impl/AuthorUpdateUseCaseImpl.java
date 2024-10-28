package fpmislata.bookstore.c_domain.usecase.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorUpdateUseCase;
import lombok.AllArgsConstructor;

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