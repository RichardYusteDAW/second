package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Author;

public interface AuthorDao {

    List<Author> findAll();

    Optional<Author> findById(Integer id);

    Optional<Author> findByBookISBN(Integer ISBN);

    Integer create(Author author);

    Boolean update(Author author);

    Boolean delete(Integer id);
}