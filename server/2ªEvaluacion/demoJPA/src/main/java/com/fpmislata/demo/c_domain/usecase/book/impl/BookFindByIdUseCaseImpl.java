package com.fpmislata.demo.c_domain.usecase.book.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookFindByIdUseCaseImpl implements BookFindByIdUseCase {

    private final BookService bookService;

    @Override
    public Book execute(Integer id) {
        return bookService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }
}