package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Author;

public interface AuthorService {

    List<Author> findAll();

    List<Author> findAllByIsbn(String isbn);

    List<Author> findAllByBookId(Integer bookId);

    List<Author> findAllByIds(List<Integer> ids);

    Author findById(Integer id);

    void save(Author author);

    void delete(Integer id);
}