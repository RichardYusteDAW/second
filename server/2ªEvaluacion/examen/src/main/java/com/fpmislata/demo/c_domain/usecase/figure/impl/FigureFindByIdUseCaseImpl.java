package com.fpmislata.demo.c_domain.usecase.figure.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Figure;
import com.fpmislata.demo.c_domain.service.interfaces.FigureService;
import com.fpmislata.demo.c_domain.usecase.figure.interfaces.FigureFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FigureFindByIdUseCaseImpl implements FigureFindByIdUseCase {

    private final FigureService figureService;

    @Override
    public Figure execute(Integer id) {
        return figureService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Figure not found"));
    }
}