package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface GenreRepository {

    List<Genre> findAll();

    ListWithCount<Genre> findAll(Integer page, Integer size);

    List<Genre> findAllByBookId(Integer bookId);

    List<Genre> findAllByIds(List<Integer> ids);

    List<Genre> findAllByIsbn(String isbn);

    Optional<Genre> findById(Integer id);

    Optional<Genre> findByName(String name);

    void save(Genre genre);

    void delete(Integer id);
}