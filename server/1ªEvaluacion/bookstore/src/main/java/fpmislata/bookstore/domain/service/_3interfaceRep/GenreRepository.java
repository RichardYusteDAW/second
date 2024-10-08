package fpmislata.bookstore.domain.service._3interfaceRep;

import java.util.List;

import fpmislata.bookstore.domain.model.Genre;

public interface GenreRepository {

    List<Genre> findAll();

    Genre findById(Integer id);

    Integer create(Genre genre);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}