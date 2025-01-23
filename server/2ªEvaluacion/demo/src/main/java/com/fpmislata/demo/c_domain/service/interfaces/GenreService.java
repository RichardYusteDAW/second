package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreService {

    List<Genre> findAll();

    List<Genre> findAllByBookId(Integer bookId);

    List<Genre> findAllByIds(List<Integer> ids);

    List<Genre> findAllByIsbn(String isbn);

    Genre findById(Integer id);

    void save(Genre genre);

    void delete(Integer id);
}