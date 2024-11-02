package fpmislata.bookstore.c_domain._1usecase.admin.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorCreateUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
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