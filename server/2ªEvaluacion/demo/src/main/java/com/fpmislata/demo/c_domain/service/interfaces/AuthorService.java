package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Author;

public interface AuthorService {

    List<Author> findAll();

    List<Author> findAllByIsbn(String isbn);

    List<Author> findAllByBookId(Integer bookId);

    List<Author> findAllByIds(List<Integer> ids);

    Optional<Author> findById(Integer id);

    Optional<Author> findByName(String name);

    void create(Author author);

    void update(Author author);

    void delete(Integer id);
}