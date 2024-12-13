package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import fpmislata.bookstore.a_common.annotation.DomainService;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookFindByIsbnAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BookFindByIsbnAdminUseCaseImpl implements BookFindByIsbnAdminUseCase {

    private final BookService bookService;

    @Override
    public Book execute(String isbn) {
        return bookService.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}