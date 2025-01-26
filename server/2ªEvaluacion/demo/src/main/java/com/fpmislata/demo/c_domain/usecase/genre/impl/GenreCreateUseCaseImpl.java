package com.fpmislata.demo.c_domain.usecase.genre.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreCreateUseCaseImpl implements GenreCreateUseCase {

    private final GenreService genreService;

    @Override
    public void execute(Genre genre) {
        genreService
                .findByName(genre.getName())
                .ifPresent(c -> {
                    throw new ResourceAlreadyExistsException("Genre already exists");
                });

        genreService.create(genre);
    }
}