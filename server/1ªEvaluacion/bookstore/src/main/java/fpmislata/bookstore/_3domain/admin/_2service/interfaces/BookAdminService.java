package fpmislata.bookstore._3domain.admin._2service.interfaces;

import fpmislata.bookstore._3domain.admin._1model.Author;
import fpmislata.bookstore._3domain.admin._1model.Book;
import fpmislata.bookstore._3domain.admin._1model.Category;
import fpmislata.bookstore._3domain.admin._1model.Genre;
import fpmislata.bookstore._3domain.admin._1model.Publisher;

import java.math.BigDecimal;
import java.util.List;

public interface BookAdminService {

    List<Book> findAll();

    Book findByISBN(String ISBN);

    Integer create(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList);

    Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList);

    Boolean delete(String ISBN);
}
