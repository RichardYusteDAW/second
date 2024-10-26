package fpmislata.bookstore.c_domain.repository;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Genre;

public interface GenreRepository {

    List<Genre> findAll();

    Optional<Genre> findById(Integer id);

    Integer create(Genre genre);

    Boolean update(Genre genre);

    Boolean delete(Integer id);
}