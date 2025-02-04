package com.fpmislata.demo.c_domain.usecase.figure.interfaces;

import com.fpmislata.demo.c_domain.model.Figure;

public interface FigureFindByIdUseCase {
    Figure execute(Integer id);
}