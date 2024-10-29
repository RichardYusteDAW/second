package fpmislata.bookstore.c_domain.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.model.Book;
import fpmislata.bookstore.c_domain.model.Category;
import fpmislata.bookstore.c_domain.model.Genre;
import fpmislata.bookstore.c_domain.model.Publisher;

public interface BookService {

        List<Book> findAll();

        Book findByISBN(String ISBN);

        Integer create(Book book);

        Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
                        Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList);

        Boolean delete(String ISBN);
}
