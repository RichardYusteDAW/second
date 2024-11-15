package fpmislata.bookstore.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.d_persistence.repository.interfaces.BookRepository;

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
        return bookRepository.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
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
}