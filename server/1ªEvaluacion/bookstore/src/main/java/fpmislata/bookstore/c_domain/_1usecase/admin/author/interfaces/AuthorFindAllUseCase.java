package fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorFindAllUseCase {

    List<Author> execute(Integer page, Integer pageSize);
}