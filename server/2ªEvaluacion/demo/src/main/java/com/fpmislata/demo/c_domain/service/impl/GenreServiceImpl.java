package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Genre;
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
    public Genre findById(Integer id) {
        return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
    }

    @Override
    public void save(Genre genre) {
        findById(genre.getId());
        genreRepository.save(genre);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        genreRepository.delete(id);
    }

}
