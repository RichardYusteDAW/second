package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Book;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    Optional<Book> findByIsbn(String isbn);

    void save(Book book);

    void delete(Integer id);
}