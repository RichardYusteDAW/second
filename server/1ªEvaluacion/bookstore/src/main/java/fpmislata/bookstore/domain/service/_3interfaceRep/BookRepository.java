package fpmislata.bookstore.domain.service._3interfaceRep;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findByISBN(String ISBN);

    Integer create(Book book);

    Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList);

    Boolean delete(String ISBN);
}