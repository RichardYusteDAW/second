package fpmislata.bookstore.c_domain.usecase.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorCreateUseCase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorCreateUseCaseImpl implements AuthorCreateUseCase {

    private final AuthorService authorService;

    @Override
    public Integer execute(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
            Integer deathYear) {
        return authorService.create(name, nationality, biographyEs, biographyEn, birthYear, deathYear);
    }
}