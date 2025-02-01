package com.fpmislata.demo.c_domain.usecase.author.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorUpdateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthorUpdateUseCaseImpl implements AuthorUpdateUseCase {

    private final AuthorService authorService;

    @Override
    public void execute(Author author) {
        authorService
                .findById(author.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        authorService.update(author);
    }
}