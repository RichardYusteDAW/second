package fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface BookInsertAuthorsAdminUseCase {
    void execute(Integer id, List<Author> authors);
}