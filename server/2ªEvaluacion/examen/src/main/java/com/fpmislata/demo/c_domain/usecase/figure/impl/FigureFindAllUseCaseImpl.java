package com.fpmislata.demo.c_domain.usecase.figure.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Figure;
import com.fpmislata.demo.c_domain.service.interfaces.FigureService;
import com.fpmislata.demo.c_domain.usecase.figure.interfaces.FigureFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FigureFindAllUseCaseImpl implements FigureFindAllUseCase {

    private final FigureService figureService;

    @Override
    public List<Figure> execute() {
        return figureService.findAll();
    }
}