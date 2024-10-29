package fpmislata.bookstore.c_domain.usecase.book.interfaces;

import fpmislata.bookstore.c_domain.model.Book;

public interface BookCreateUseCase {
    Integer execute(Book book);
}
