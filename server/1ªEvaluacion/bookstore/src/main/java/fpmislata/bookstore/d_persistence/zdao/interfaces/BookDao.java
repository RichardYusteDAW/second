package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookDao {

    List<Book> getAll(Integer page, Integer size);

    Integer count(Integer page, Integer size);

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(Long id);

    Optional<Long> save(Book book);
}