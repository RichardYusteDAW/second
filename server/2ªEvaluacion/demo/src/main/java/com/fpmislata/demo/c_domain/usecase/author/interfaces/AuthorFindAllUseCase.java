package com.fpmislata.demo.c_domain.usecase.author.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Author;

public interface AuthorFindAllUseCase {
    List<Author> execute();
}