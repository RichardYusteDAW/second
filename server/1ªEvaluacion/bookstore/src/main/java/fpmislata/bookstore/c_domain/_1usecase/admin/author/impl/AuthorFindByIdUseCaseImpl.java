package fpmislata.bookstore.c_domain._1usecase.admin.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorFindByIdUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain._2service.model.Author;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorFindByIdUseCaseImpl implements AuthorFindByIdUseCase {

    private final AuthorService authorService;

    @Override
    public Author execute(Long id) {
        return authorService.findById(id);
    }
}