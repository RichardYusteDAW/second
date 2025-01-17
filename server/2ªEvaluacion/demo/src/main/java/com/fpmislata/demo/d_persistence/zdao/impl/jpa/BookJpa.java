package com.fpmislata.demo.d_persistence.zdao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.impl.model.BookEntity;

public interface BookJpa extends JpaRepository<BookEntity, Integer> {

    @Query(value = "SELECT * FROM books WHERE isbn = :isbn", nativeQuery = true)
    BookEntity findByIsbn(String isbn);
}