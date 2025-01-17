package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.Genre;

public interface BookDao extends GenericDao<Book> {

    Optional<Book> findByIsbn(String isbn);

    void deleteAuthors(Integer id);

    void insertAuthors(Integer id, List<Author> authors);

    void deleteGenres(Integer id);

    void insertGenres(Integer id, List<Genre> genres);
}