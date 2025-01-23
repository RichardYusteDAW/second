package com.fpmislata.demo.c_domain.usecase.author.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
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
        authorService.create(author);
    }
}