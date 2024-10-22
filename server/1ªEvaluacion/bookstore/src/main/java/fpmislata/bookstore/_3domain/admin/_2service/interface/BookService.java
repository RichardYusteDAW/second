package fpmislata.bookstore._3domain.admin.service._1interfaceSer;

import java.math.BigDecimal;
import java.util.List;

import fpmislata.bookstore._3domain.model.AuthorCommand;
import fpmislata.bookstore._3domain.model.Book;
import fpmislata.bookstore._3domain.model.Category;
import fpmislata.bookstore._3domain.model.Genre;
import fpmislata.bookstore._3domain.model.Publisher;

public interface BookService {

        List<Book> findAll();

        Book findByISBN(String ISBN);

        Integer create(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
                        Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList);

        Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
                        Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList);

        Boolean delete(String ISBN);
}