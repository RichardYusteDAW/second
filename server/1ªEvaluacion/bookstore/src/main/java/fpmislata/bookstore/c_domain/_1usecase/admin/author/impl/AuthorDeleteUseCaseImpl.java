package fpmislata.bookstore.c_domain._1usecase.admin.author.impl;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorDeleteUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
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