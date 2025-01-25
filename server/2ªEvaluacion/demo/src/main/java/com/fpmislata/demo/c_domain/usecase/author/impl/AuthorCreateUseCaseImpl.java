package com.fpmislata.demo.c_domain.usecase.author.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthorCreateUseCaseImpl implements AuthorCreateUseCase {

    private final AuthorService authorService;

    @Override
    public void execute(Author author) {
        // Optional<Author> authorOptional = authorService.findByName(author.getName());
        // if (authorOptional.isPresent()) {
        //     throw new ResourceAlreadyExistsException("Author already exists");
        // }
        authorService
                .findByName(author.getName())
                .ifPresent(a -> {
                    throw new ResourceAlreadyExistsException("Author already exists");
                });

        authorService.create(author);
    }
}