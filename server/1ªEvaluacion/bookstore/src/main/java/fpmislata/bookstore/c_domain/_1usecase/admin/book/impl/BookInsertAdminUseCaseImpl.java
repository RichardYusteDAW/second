package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookInsertAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookInsertAdminUseCaseImpl implements BookInsertAdminUseCase {

    private final BookService bookService;

    public Long execute(Book book) {
        // Check if the book already exists
        if (bookService.findByIsbn(book.getIsbn()) != null) {
            throw new RuntimeException("Book already exists");
        }
        return bookService.save(book).orElseThrow(() -> new RuntimeException("Error saving book"));
    }
}