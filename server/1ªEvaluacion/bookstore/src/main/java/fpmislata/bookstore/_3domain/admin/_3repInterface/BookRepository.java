package fpmislata.bookstore._3domain.admin._3repInterface;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import fpmislata.bookstore._3domain.model.AuthorCommand;
import fpmislata.bookstore._3domain.model.Book;
import fpmislata.bookstore._3domain.model.Category;
import fpmislata.bookstore._3domain.model.Genre;
import fpmislata.bookstore._3domain.model.Publisher;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findByISBN(String ISBN);

    Integer create(Book book);

    Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList);

    Boolean delete(String ISBN);
}