package com.fpmislata.demo.c_domain.usecase.genre.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreDeleteUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GenreDeleteUseCaseImpl implements GenreDeleteUseCase {

    private final GenreService genreService;

    @Override
    public void execute(Integer id) {
        genreService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));

        genreService.delete(id);
    }
}