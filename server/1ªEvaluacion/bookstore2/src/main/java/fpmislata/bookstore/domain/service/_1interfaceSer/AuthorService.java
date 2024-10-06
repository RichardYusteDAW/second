package fpmislata.bookstore.domain.service._1interfaceSer;

import java.util.List;

import fpmislata.bookstore.domain.model.Author;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Integer id);

    Integer create(long id, String name, String nationality, String biography, int birthYear, int deathYear);

    Boolean update(long id, String name, String nationality, String biography, int birthYear, int deathYear);

    Boolean delete(Integer id);
}