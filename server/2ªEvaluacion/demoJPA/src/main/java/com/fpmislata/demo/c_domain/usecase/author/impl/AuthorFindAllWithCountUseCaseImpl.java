package com.fpmislata.demo.c_domain.usecase.author.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllWithCountUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthorFindAllWithCountUseCaseImpl implements AuthorFindAllWithCountUseCase {

    private final AuthorService authorService;

    @Override
    public ListWithCount<Author> execute(Integer page, Integer size) {
        return authorService.findAll(page, size);
    }
}