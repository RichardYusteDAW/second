package com.fpmislata.demo.c_domain.usecase.genre.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreFindByIdUseCaseImpl implements GenreFindByIdUseCase {

    private final GenreService genreService;

    @Override
    public Genre execute(Integer id) {
        return genreService.findById(id);
    }
}