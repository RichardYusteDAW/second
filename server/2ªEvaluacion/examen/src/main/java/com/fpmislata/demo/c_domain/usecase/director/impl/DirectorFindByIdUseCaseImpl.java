package com.fpmislata.demo.c_domain.usecase.director.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Director;
import com.fpmislata.demo.c_domain.service.interfaces.DirectorService;
import com.fpmislata.demo.c_domain.usecase.director.interfaces.DirectorFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorFindByIdUseCaseImpl implements DirectorFindByIdUseCase {

    private final DirectorService directorService;

    @Override
    public Director execute(Integer id) {
        return directorService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));
    }
}