package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookRepository {

    List<Book> getAll(Integer page, Integer size);

    Optional<Book> findByIsbn(String isbn);

    Optional<Long> save(Book book);

    Integer count();
}