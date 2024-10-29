package fpmislata.bookstore.c_domain.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.a_common.exception.ResourceNotFoundException;
import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.model.Book;
import fpmislata.bookstore.c_domain.model.Category;
import fpmislata.bookstore.c_domain.model.Genre;
import fpmislata.bookstore.c_domain.model.Publisher;
import fpmislata.bookstore.c_domain.repository.BookRepository;
import fpmislata.bookstore.c_domain.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN).orElseThrow(() -> new ResourceNotFoundException("Book does not exist"));
    }

    @Override
    public Integer create(Book book) {
        // comprobar que el id sea un id
        // comprobar que el titulo no exista en la db
        // comprobar que la categoria existe

        return bookRepository.create(book);
    }

    @Override
    public Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList) {
        return bookRepository.update(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @Override
    public Boolean delete(String ISBN) {
        return bookRepository.delete(ISBN);
    }
}