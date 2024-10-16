package fpmislata.bookstore.domain.service._2impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.common.exception.ResourceNotFoundException;
import fpmislata.bookstore.domain.model.AuthorCommand;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service._1interfaceSer.BookService;
import fpmislata.bookstore.domain.service._3interfaceRep.BookRepository;
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
    public Integer create(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList) {
        // comprobar que el id sea un id
        // comprobar que el titulo no exista en la db
        // comprobar que la categoria existe

        Book book = new Book(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList, genreList);
        return bookRepository.create(book);
    }

    @Override
    public Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList) {
        return bookRepository.update(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @Override
    public Boolean delete(String ISBN) {
        return bookRepository.delete(ISBN);
    }
}