package com.fpmislata.demo.c_domain.usecase.book.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookUpdateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookUpdateUseCaseImpl implements BookUpdateUseCase {

    private final BookService bookService;

    @Override
    public void execute(Book book) {
        bookService.update(book);
    }
}