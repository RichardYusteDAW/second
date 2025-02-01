package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface BookService {

    List<Book> findAll();

    ListWithCount<Book> findAll(Integer page, Integer size);

    Optional<Book> findById(Integer id);

    Optional<Book> findByIsbn(String isbn);

    void create(Book book);

    void update(Book book);

    void delete(Integer id);
}