package com.fpmislata.demo.c_domain.usecase.book.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookDeleteUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookDeleteUseCaseImpl implements BookDeleteUseCase {

    private final BookService bookService;

    @Override
    public void execute(Integer id) {
        bookService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        bookService.delete(id);
    }
}