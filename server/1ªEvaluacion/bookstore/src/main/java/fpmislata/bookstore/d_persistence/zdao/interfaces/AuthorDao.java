package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorDao {

    List<Author> findAll();

    List<Author> findAllById(List<Long> authorIdList);

    List<Author> findAllByBookId(Long bookId);

    Optional<Author> findById(Long id);

    Optional<Author> findByBookISBN(Integer ISBN);

    Long create(Author author);

    Boolean update(Author author);

    Boolean delete(Long id);
}