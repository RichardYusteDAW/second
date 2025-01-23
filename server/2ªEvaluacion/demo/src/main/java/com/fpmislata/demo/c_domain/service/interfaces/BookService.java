package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Book;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer id);

    Book findByIsbn(String isbn);

    void save(Book book);

    void delete(Integer id);
}