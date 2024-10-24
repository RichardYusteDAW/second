package fpmislata.bookstore._3domain.admin._2service.interfaces;

import java.util.List;

import fpmislata.bookstore._3domain.admin._1model.Genre;

public interface GenreAdminService {

    List<Genre> findAll();

    Genre findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}