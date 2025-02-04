package com.fpmislata.demo.c_domain.usecase.director.interfaces;

import com.fpmislata.demo.c_domain.model.Director;

public interface DirectorFindByIdUseCase {
    Director execute(Integer id);
}