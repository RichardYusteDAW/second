package fpmislata.bookstore.domain.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service.interfaceRep.BookRepository;
import fpmislata.bookstore.domain.service.interfaceSer.BookService;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN);
    }

    @Override
    public Integer create(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList) {
        // comprobar que el id sea un id
        // comprobar que el titulo no exista en la db
        // comprobar que la categoria existe

        Book book = new Book(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList, genreList);
        return bookRepository.create(book);
    }

    @Override
    public Integer update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(String ISBN) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}