package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.GenreRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.GenreJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.GenreMapper;
import com.fpmislata.demo.d_persistence.jpa.model.GenreEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreJpa genreJpa;

    @Override
    public List<Genre> findAll() {
        return GenreMapper.INSTANCE.toGenreList(genreJpa.findAll());
    }

    @Override
    public ListWithCount<Genre> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<GenreEntity> genreEntityPage = genreJpa.findAll(pageable);

        List<Genre> genreList = GenreMapper.INSTANCE.toGenreList(genreEntityPage.getContent());
        Integer count = (int) genreEntityPage.getTotalElements();

        return new ListWithCount<>(genreList, count);
    }

    @Override
    public List<Genre> findAllByBookId(Integer bookId) {
        return GenreMapper.INSTANCE.toGenreList(genreJpa.findAllByBookId(bookId));
    }

    @Override
    public List<Genre> findAllByIds(List<Integer> ids) {
        return GenreMapper.INSTANCE.toGenreList(genreJpa.findAllByIds(ids));
    }

    @Override
    public List<Genre> findAllByIsbn(String isbn) {
        return GenreMapper.INSTANCE.toGenreList(genreJpa.findAllByIsbn(isbn));
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
        genreJpa.save(GenreMapper.INSTANCE.toGenreEntity(genre));
    }

    @Override
    public void delete(Integer id) {
        genreJpa.deleteById(id);
    }
}