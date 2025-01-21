package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.Genre;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    Optional<Book> findByIsbn(String isbn);

    void save(Book book);

    void delete(Integer id);

    void deleteAuthors(Integer id);

    void insertAuthors(Integer id, List<Author> authors);

    void deleteGenres(Integer id);

    void insertGenres(Integer id, List<Genre> genres);
}