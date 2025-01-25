package com.fpmislata.demo.d_persistence.zdao.jpa.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.jpa.model.AuthorEntity;

public interface AuthorJpa extends JpaRepository<AuthorEntity, Integer> {

        Optional<AuthorEntity> findByName(String name);

        @Query(value = "SELECT a.* FROM authors a" +
                        "JOIN books_authors ON authors.id = author_id " +
                        "JOIN books ON books.id = book_id " +
                        "WHERE isbn = :isbn", nativeQuery = true)
        List<AuthorEntity> findAllByIsbn(String isbn);

        @Query(value = "SELECT a.* FROM authors a" +
                        "JOIN books_authors ON authors.id = author_id " +
                        "WHERE book_id = :id ", nativeQuery = true)
        List<AuthorEntity> findAllByBookId(Integer id);

        @Query(value = "SELECT * FROM authors WHERE id in (:ids)", nativeQuery = true)
        List<AuthorEntity> findAllByIds(List<Integer> ids);
}