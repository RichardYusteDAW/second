package fpmislata.bookstore.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.a_common.exception.ResourceNotFoundException;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.c_domain._2service.model.Genre;
import fpmislata.bookstore.d_persistence.repository.interfaces.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll(Integer page, Integer size) {
        return bookRepository.getAll(page, size);
    }

    @Override
    public Integer count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
    }

    @Override
    public Book findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<Long> save(Book book) {
        if (!bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            return Optional.empty();
        }
        return bookRepository.save(book);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        throw new UnsupportedOperationException("Unimplemented method 'addAuthor'");
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        throw new UnsupportedOperationException("Unimplemented method 'addGenre'");
    }

}