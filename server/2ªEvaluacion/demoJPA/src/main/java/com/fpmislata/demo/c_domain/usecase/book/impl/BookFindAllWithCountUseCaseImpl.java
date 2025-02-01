package com.fpmislata.demo.c_domain.usecase.book.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindAllWithCountUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookFindAllWithCountUseCaseImpl implements BookFindAllWithCountUseCase {

    private final BookService bookService;

    @Override
    public ListWithCount<Book> execute(Integer page, Integer size) {
        return bookService.findAll(page, size);
    }
}