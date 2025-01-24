package com.fpmislata.demo.d_persistence.zdao.jpa.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.d_persistence.zdao.interfaces.GenreDao;
import com.fpmislata.demo.d_persistence.zdao.jpa.interfaces.GenreJpa;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.GenreMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.GenreEntity;

import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

    private final GenreJpa genreJpa;

    @Override
    public List<Genre> findAll() {
        List<GenreEntity> genreEntityList = genreJpa.findAll();
        return GenreMapper.INSTANCE.toGenreList(genreEntityList);
    }

    @Override
    public List<Genre> findAllByBookId(Integer bookId) {
        List<GenreEntity> genreEntityList = genreJpa.findAllByBookId(bookId);
        return GenreMapper.INSTANCE.toGenreList(genreEntityList);
    }

    @Override
    public List<Genre> findAllByIds(List<Integer> ids) {
        List<GenreEntity> genreEntityList = genreJpa.findAllByIds(ids);
        return GenreMapper.INSTANCE.toGenreList(genreEntityList);
    }

    @Override
    public List<Genre> findAllByIsbn(String isbn) {
        List<GenreEntity> genreEntityList = genreJpa.findAllByIsbn(isbn);
        return GenreMapper.INSTANCE.toGenreList(genreEntityList);
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreJpa
                .findById(id)
                .map(g -> GenreMapper.INSTANCE.toGenre(g));
    }

    @Override
    public Optional<Genre> findByName(String name) {
        return genreJpa
                .findByName(name)
                .map(g -> GenreMapper.INSTANCE.toGenre(g));
    }

    @Override
    public void save(Genre genre) {
        GenreEntity genreEntity = GenreMapper.INSTANCE.toGenreEntity(genre);
        genreJpa.save(genreEntity);
    }

    @Override
    public void delete(Integer id) {
        genreJpa.deleteById(id);
    }
}