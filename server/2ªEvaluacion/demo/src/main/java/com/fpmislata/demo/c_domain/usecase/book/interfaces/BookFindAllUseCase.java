package com.fpmislata.demo.c_domain.usecase.book.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Book;

public interface BookFindAllUseCase {
    List<Book> execute();
}