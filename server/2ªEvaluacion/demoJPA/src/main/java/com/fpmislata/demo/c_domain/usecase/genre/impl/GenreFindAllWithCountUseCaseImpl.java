package com.fpmislata.demo.c_domain.usecase.genre.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindAllWithCountUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreFindAllWithCountUseCaseImpl implements GenreFindAllWithCountUseCase {

    private final GenreService genreService;

    @Override
    public ListWithCount<Genre> execute(Integer page, Integer size) {
        return genreService.findAll(page, size);
    }
}