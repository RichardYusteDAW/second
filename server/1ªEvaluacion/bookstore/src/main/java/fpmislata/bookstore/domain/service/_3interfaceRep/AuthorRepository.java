package fpmislata.bookstore.domain.service._3interfaceRep;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.domain.model.Author;

public interface AuthorRepository {

    List<Author> findAll();

    Optional<Author> findById(Integer id);

    Integer create(Author author);

    Boolean update(long id, String name, String nationality, String biography, Integer birthYear, Integer deathYear);

    Boolean delete(Integer id);
}