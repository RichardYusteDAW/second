package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookUpdateAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookUpdateAdminUseCaseImpl implements BookUpdateAdminUseCase {

    private final BookService bookService;

    @Override
    public Long execute(Book book) {
        return bookService.update(book)
                .orElseThrow(() -> new RuntimeException("Error updating book"));
    }
}
