package fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces;

import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookUpdateAdminUseCase {
    Long execute(Book book);
}