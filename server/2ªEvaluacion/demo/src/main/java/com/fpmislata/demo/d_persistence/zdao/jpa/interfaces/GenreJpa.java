package com.fpmislata.demo.d_persistence.zdao.jpa.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.zdao.jpa.model.GenreEntity;

public interface GenreJpa extends JpaRepository<GenreEntity, Integer> {

        @Query(value = "SELECT * FROM genres WHERE name_es = :name OR name_en = :name", nativeQuery = true)
        Optional<GenreEntity> findByName(String name);

        @Query(value = "SELECT g.* FROM genres g" +
                        "JOIN books_genres ON genres.id = genre_id " +
                        "JOIN books ON books.id = book_id " +
                        "WHERE isbn = :isbn", nativeQuery = true)
        List<GenreEntity> findAllByIsbn(String isbn);

        @Query(value = "SELECT g.* FROM genres g" +
                        "JOIN books_genres ON genres.id = genre_id " +
                        "WHERE book_id = :id ", nativeQuery = true)
        List<GenreEntity> findAllByBookId(Integer id);

        @Query(value = "SELECT * FROM genres g WHERE id IN (:ids)", nativeQuery = true)
        List<GenreEntity> findAllByIds(List<Integer> ids);
}