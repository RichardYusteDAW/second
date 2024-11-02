package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorRepository {

    List<Author> findAll();

    Optional<Author> findById(Integer id);

    Optional<Author> findByBookISBN(Integer ISBN);

    Integer create(Author author);

    Boolean update(Author author);

    Boolean delete(Integer id);
}