package com.fpmislata.demo.c_domain.usecase.genre.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreUpdateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreUpdateUseCaseImpl implements GenreUpdateUseCase {

    private final GenreService genreService;

    @Override
    public void execute(Genre genre) {
        genreService.update(genre);
    }
}