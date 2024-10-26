package fpmislata.bookstore.c_domain.repository;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Author;

public interface AuthorRepository {

    List<Author> findAll();

    Optional<Author> findById(Integer id);

    Optional<Author> findByBookISBN(Integer ISBN);

    Integer create(Author author);

    Boolean update(Integer id, String name, String nationality, String biography_en, String biography_es,
            Integer birthYear, Integer deathYear);

    Boolean delete(Integer id);
}