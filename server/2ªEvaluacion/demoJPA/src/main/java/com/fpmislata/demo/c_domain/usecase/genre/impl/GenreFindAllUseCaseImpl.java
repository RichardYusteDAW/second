package com.fpmislata.demo.c_domain.usecase.genre.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreFindAllUseCaseImpl implements GenreFindAllUseCase {

    private final GenreService genreService;

    @Override
    public List<Genre> execute() {
        return genreService.findAll();
    }
}