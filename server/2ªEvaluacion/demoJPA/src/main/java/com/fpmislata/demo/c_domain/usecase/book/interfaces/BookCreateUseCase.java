package com.fpmislata.demo.c_domain.usecase.book.interfaces;

import com.fpmislata.demo.c_domain.model.Book;

public interface BookCreateUseCase {
    void execute(Book book);
}