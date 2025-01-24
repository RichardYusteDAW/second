package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreDao extends GenericDao<Genre> {

    Optional<Genre> findByName(String name);

    List<Genre> findAllByBookId(Integer bookId);

    List<Genre> findAllByIds(List<Integer> ids);

    List<Genre> findAllByIsbn(String isbn);
}