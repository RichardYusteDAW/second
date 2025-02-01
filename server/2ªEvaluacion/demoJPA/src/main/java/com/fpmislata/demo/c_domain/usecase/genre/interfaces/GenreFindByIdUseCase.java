package com.fpmislata.demo.c_domain.usecase.genre.interfaces;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreFindByIdUseCase {
    Genre execute(Integer id);
}
