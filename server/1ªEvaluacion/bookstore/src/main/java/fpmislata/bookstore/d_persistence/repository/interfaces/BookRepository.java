package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookRepository {

    List<Book> getAll(int page, int size);

    Integer count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(Long id);

    Optional<Long> save(Book book);
}