package fpmislata.bookstore.c_domain.service.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain.model.Genre;

public interface GenreService {

    List<Genre> findAll();

    Genre findById(Integer id);

    Integer create(String nameES, String nameEN, String slug);

    Boolean update(Long id, String nameES, String nameEN, String slug);

    Boolean delete(Integer id);
}