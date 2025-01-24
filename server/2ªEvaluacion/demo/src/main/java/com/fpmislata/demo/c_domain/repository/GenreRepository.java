package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreRepository {

    List<Genre> findAll();

    List<Genre> findAllByBookId(Integer bookId);

    List<Genre> findAllByIds(List<Integer> ids);

    List<Genre> findAllByIsbn(String isbn);

    Optional<Genre> findById(Integer id);

    Optional<Genre> findByName(String name);

    void save(Genre genre);

    void delete(Integer id);
}