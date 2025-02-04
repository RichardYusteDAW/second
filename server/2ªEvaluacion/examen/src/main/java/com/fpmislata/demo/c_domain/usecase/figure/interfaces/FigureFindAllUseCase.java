package com.fpmislata.demo.c_domain.usecase.figure.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Figure;

public interface FigureFindAllUseCase {
    List<Figure> execute();
}