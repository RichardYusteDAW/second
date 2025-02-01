package com.fpmislata.demo.c_domain.usecase.author.interfaces;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface AuthorFindAllWithCountUseCase {
    ListWithCount<Author> execute(Integer page, Integer size);
}