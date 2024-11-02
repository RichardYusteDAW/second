package fpmislata.bookstore.c_domain._1usecase.admin.author.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorFindAllUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain._2service.model.Author;
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