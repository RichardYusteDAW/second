package fpmislata.bookstore.c_domain.usecase.author.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorFindAllUseCase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorFindAllUseCaseImpl implements AuthorFindAllUseCase {

    private final AuthorService authorService;

    @Override
    public List<Author> execute(Integer page, Integer pageSize) {
        return authorService.findAll();
    }
}