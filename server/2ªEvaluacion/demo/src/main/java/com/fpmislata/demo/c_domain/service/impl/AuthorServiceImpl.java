package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Author;
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
    public Author findById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    public void save(Author author) {
        findById(author.getId());
        authorRepository.save(author);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        authorRepository.delete(id);
    }
}