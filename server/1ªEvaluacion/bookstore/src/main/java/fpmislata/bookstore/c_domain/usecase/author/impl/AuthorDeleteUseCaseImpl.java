package fpmislata.bookstore.c_domain.usecase.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorDeleteUseCase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorDeleteUseCaseImpl implements AuthorDeleteUseCase {

    private final AuthorService authorService;

    @Override
    public Boolean execute(Integer id) {
        return authorService.delete(id);
    }
}