package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.GenreRepository;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public ListWithCount<Genre> findAll(Integer page, Integer size) {
        return genreRepository.findAll(page, size);
    }

    @Override
    public List<Genre> findAllByBookId(Integer bookId) {
        return genreRepository.findAllByBookId(bookId);
    }

    @Override
    public List<Genre> findAllByIds(List<Integer> ids) {
        return genreRepository.findAllByIds(ids);
    }

    @Override
    public List<Genre> findAllByIsbn(String isbn) {
        return genreRepository.findAllByIsbn(isbn);
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreRepository.findById(id);
    }

    @Override
    public Optional<Genre> findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void update(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void delete(Integer id) {
        genreRepository.delete(id);
    }
}