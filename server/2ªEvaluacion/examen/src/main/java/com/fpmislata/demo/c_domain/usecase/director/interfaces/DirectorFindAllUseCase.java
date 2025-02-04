package com.fpmislata.demo.c_domain.usecase.director.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Director;

public interface DirectorFindAllUseCase {
    List<Director> execute();
}