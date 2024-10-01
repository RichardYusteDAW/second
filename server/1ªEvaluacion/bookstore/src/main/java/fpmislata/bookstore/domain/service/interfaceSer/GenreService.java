package fpmislata.bookstore.domain.service.interfaceSer;

import java.util.List;

import fpmislata.bookstore.domain.model.Genre;

public interface GenreService {

    List<Genre> findAll();

    Genre findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}