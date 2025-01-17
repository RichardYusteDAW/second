package com.fpmislata.demo.d_persistence.zdao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.impl.model.GenreEntity;

public interface GenreJpa extends JpaRepository<GenreEntity, Integer> {
        @Query(value = "SELECT g.* FROM genres g" +
                        "JOIN books_genres ON genres.id = genre_id " +
                        "JOIN books ON books.id = book_id " +
                        "WHERE isbn = :isbn", nativeQuery = true)
        List<GenreEntity> findAllByIsbn(String isbn);

        @Query(value = "SELECT g.* FROM genres g" +
                        "JOIN books_genres ON genres.id = genre_id " +
                        "WHERE book_id = :id ", nativeQuery = true)
        List<GenreEntity> findAllByBookId(Integer id);
}