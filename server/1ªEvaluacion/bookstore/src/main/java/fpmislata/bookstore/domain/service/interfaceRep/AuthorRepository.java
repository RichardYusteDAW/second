package fpmislata.bookstore.domain.service.interfaceRep;

import java.util.List;

import fpmislata.bookstore.domain.model.Author;

public interface AuthorRepository {

    List<Author> findAll();

    Author findById(Integer id);

    Integer create(Author author);

    Boolean update(long id, String name, String nationality, String biography, int birthYear, int deathYear);

    Boolean delete(Integer id);
}