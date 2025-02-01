package com.fpmislata.demo.c_domain.usecase.genre.interfaces;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface GenreFindAllWithCountUseCase {
    ListWithCount<Genre> execute(Integer page, Integer size);
}