package fpmislata.bookstore.c_domain.usecase.author.interfaces;

import fpmislata.bookstore.c_domain.model.Author;

public interface AuthorFindByIdUseCase {

    Author execute(Integer id);
}