package com.fpmislata.demo.d_persistence.zdao.jpa.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.jpa.model.BookEntity;

public interface BookJpa extends JpaRepository<BookEntity, Integer> {

    @Query(value = "SELECT * FROM books WHERE isbn = :isbn", nativeQuery = true)
    Optional<BookEntity> findByIsbn(String isbn);
}