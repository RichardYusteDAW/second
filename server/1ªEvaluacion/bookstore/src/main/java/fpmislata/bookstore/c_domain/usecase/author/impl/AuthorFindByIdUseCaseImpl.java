package fpmislata.bookstore.c_domain.usecase.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorFindByIdUseCase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorFindByIdUseCaseImpl implements AuthorFindByIdUseCase {

    private final AuthorService authorService;

    @Override
    public Author execute(Integer id) {
        return authorService.findById(id);
    }
}