package com.fpmislata.demo.c_domain.usecase.director.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Director;
import com.fpmislata.demo.c_domain.service.interfaces.DirectorService;
import com.fpmislata.demo.c_domain.usecase.director.interfaces.DirectorFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorFindAllUseCaseImpl implements DirectorFindAllUseCase {

    private final DirectorService directorService;

    @Override
    public List<Director> execute() {
        return directorService.findAll();
    }
}