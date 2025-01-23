package com.fpmislata.demo.c_domain.usecase.genre.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreFindAllUseCase {
    List<Genre> execute();
}