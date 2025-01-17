package com.fpmislata.demo.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.repository.interfaces.GenreRepository;
import com.fpmislata.demo.d_persistence.zdao.interfaces.GenreDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDao genreDao;

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public List<Genre> findAllByBookId(Integer bookId) {
        return genreDao.findAllByBookId(bookId);
    }

    @Override
    public List<Genre> findAllByIds(List<Integer> ids) {
        return genreDao.findAllByIds(ids);
    }

    @Override
    public List<Genre> findAllByIsbn(String isbn) {
        return genreDao.findAllByIsbn(isbn);
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreDao.findById(id);
    }

    @Override
    public void save(Genre genre) {
        genreDao.save(genre);
    }

    @Override
    public void delete(Integer id) {
        genreDao.delete(id);
    }
}