package fpmislata.bookstore.domain.service._1interfaceSer;

import java.util.List;

import fpmislata.bookstore.domain.model.Author;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Integer id);

    Integer create(String name, String nationality, String biography, Integer birthYear, Integer deathYear);

    Boolean update(long id, String name, String nationality, String biography, Integer birthYear, Integer deathYear);

    Boolean delete(Integer id);
}