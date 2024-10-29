package fpmislata.bookstore.c_domain.usecase.book.impl;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain.model.Book;
import fpmislata.bookstore.c_domain.service.interfaces.BookService;
import fpmislata.bookstore.c_domain.usecase.book.interfaces.BookCreateUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookCreateUseCaseImpl implements BookCreateUseCase {

    private final BookService bookService;

    @Override
    public Integer execute(Book book) {
        return bookService.create(book);
    }
}