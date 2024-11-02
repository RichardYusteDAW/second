package fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorFindByIdUseCase {

    Author execute(Integer id);
}