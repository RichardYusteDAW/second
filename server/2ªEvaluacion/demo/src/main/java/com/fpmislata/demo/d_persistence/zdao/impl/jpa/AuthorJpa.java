package com.fpmislata.demo.d_persistence.zdao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.impl.model.AuthorEntity;

public interface AuthorJpa extends JpaRepository<AuthorEntity, Integer> {

    @Query(value = "SELECT a.* FROM authors a" +
            "JOIN books_authors ON authors.id = author_id " +
            "JOIN books ON books.id = book_id " +
            "WHERE isbn = :isbn", nativeQuery = true)
    List<AuthorEntity> findAllByIsbn(String isbn);

    @Query(value = "SELECT a.* FROM authors a" +
            "JOIN books_authors ON authors.id = author_id " +
            "WHERE book_id = :id ", nativeQuery = true)
    List<AuthorEntity> findAllByBookId(Integer id);
}