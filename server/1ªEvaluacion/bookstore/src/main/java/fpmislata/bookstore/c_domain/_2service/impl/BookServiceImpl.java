package fpmislata.bookstore.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
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
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Long> create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Long> update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Integer count() {
        return bookRepository.count();
    }
}