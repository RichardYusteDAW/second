package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.a_common.exception.ResourceNotFoundException;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookInsertAuthorsAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookInsertAuthorsAdminUseCaseImpl implements BookInsertAuthorsAdminUseCase {

    private final AuthorService authorService;
    private final BookService bookService;

    @Override
    public void execute(Long bookId, List<Author> authors) {

        // Find book by id
        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book id " + bookId + " not found"));

        // Add authors to book
        authorService
                .findAllById(authors)
                .forEach(author -> bookService.addAuthor(book, author));

        //Save book
        bookService.save(book);
    }
}