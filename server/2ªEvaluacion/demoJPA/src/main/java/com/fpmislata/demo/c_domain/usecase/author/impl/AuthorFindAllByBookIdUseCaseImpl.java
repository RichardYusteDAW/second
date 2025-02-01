package com.fpmislata.demo.c_domain.usecase.author.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllByBookIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthorFindAllByBookIdUseCaseImpl implements AuthorFindAllByBookIdUseCase {

    private final AuthorService authorService;

    @Override
    public List<Author> execute(Integer bookId) {
        return authorService.findAllByBookId(bookId);
    }
}