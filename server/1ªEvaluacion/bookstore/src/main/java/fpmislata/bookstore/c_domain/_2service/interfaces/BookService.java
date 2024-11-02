package fpmislata.bookstore.c_domain._2service.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.c_domain._2service.model.Genre;

public interface BookService {

        List<Book> getAll(Integer page, Integer size);

        Integer count();

        Book findByIsbn(String isbn);

        Book findById(Long id);

        Optional<Long> save(Book book);

        void addAuthor(Book book, Author author);

        void addGenre(Book book, Genre genre);
}
