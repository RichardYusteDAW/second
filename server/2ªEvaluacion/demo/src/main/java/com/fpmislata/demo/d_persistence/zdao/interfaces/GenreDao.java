package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Genre;

public interface GenreDao extends GenericDao<Genre> {

    List<Genre> findAllByBookId(Integer bookId);

    List<Genre> findAllByIds(List<Integer> ids);

    List<Genre> findAllByIsbn(String isbn);
}