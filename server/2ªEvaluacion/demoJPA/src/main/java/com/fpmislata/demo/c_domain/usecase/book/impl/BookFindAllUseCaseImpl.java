package com.fpmislata.demo.c_domain.usecase.book.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookFindAllUseCaseImpl implements BookFindAllUseCase {

    private final BookService bookService;

    @Override
    public List<Book> execute() {
        return bookService.findAll();
    }
}