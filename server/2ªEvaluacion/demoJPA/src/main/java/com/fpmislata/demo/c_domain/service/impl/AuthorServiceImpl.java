package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.AuthorRepository;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public ListWithCount<Author> findAll(Integer page, Integer size) {
        return authorRepository.findAll(page, size);
    }

    @Override
    public List<Author> findAllByIsbn(String isbn) {
        return authorRepository.findAllByIsbn(isbn);
    }

    @Override
    public List<Author> findAllByBookId(Integer bookId) {
        return authorRepository.findAllByBookId(bookId);
    }

    @Override
    public List<Author> findAllByIds(List<Integer> ids) {
        return authorRepository.findAllByIds(ids);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void create(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Integer id) {
        authorRepository.delete(id);
    }
}