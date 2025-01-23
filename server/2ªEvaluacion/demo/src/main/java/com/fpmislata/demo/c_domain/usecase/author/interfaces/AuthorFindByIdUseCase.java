package com.fpmislata.demo.c_domain.usecase.author.interfaces;

import com.fpmislata.demo.c_domain.model.Author;

public interface AuthorFindByIdUseCase {
    Author execute(Integer id);
}