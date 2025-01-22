package com.fpmislata.demo.d_persistence.zdao.jpa.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.d_persistence.zdao.interfaces.BookDao;
import com.fpmislata.demo.d_persistence.zdao.jpa.interfaces.BookJpa;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.AuthorMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.BookMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.GenreMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.BookEntity;

import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final BookJpa bookJpa;

    @Override
    public List<Book> findAll() {
        List<BookEntity> bookEntityList = bookJpa.findAll();
        return BookMapper.INSTANCE.toBookList(bookEntityList);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookJpa
                .findById(id)
                .map(b -> BookMapper.INSTANCE.toBookWithDetails(b));
    }

    @Override
    public void save(Book book) {
        bookJpa.save(BookMapper.INSTANCE.toBookEntity(book));
    }

    @Override
    public void delete(Integer id) {
        bookJpa.deleteById(id);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookJpa
                .findByIsbn(isbn)
                .map(b -> BookMapper.INSTANCE.toBookWithDetails(b));
    }

    @Override
    public void deleteAuthors(Integer id) {
        bookJpa.findById(id)
                .ifPresent(b -> b.getAuthors().clear());
    }

    @Override
    public void insertAuthors(Integer id, List<Author> authors) {
        bookJpa.findById(id)
                .ifPresent(b -> b.setAuthors(AuthorMapper.INSTANCE.toAuthorEntityList(authors)));
    }

    @Override
    public void deleteGenres(Integer id) {
        bookJpa.findById(id)
                .ifPresent(b -> b.getGenres().clear());
    }

    @Override
    public void insertGenres(Integer id, List<Genre> genres) {
        bookJpa.findById(id)
                .ifPresent(b -> b.setGenres(GenreMapper.INSTANCE.toGenreEntityList(genres)));
    }
}