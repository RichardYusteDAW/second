package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorRepository {

    List<Author> findAll();

    List<Author> findAllById(List<Long> authorIdList);

    Optional<Author> findById(Long id);

    Optional<Author> findByBookISBN(Integer ISBN);

    Long create(Author author);

    Boolean update(Author author);

    Boolean delete(Long id);
}