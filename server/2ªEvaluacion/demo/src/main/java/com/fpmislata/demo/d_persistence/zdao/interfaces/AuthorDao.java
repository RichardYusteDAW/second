package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Author;

public interface AuthorDao extends GenericDao<Author> {

    List<Author> findAllByIsbn(String isbn);

    List<Author> findAllByBookId(Integer bookId);

    List<Author> findAllByIds(List<Integer> ids);
}