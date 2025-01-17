package com.fpmislata.demo.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.repository.interfaces.AuthorRepository;
import com.fpmislata.demo.d_persistence.zdao.interfaces.AuthorDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDao authorDao;

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public List<Author> findAllByIsbn(String isbn) {
        return authorDao.findAllByIsbn(isbn);
    }

    @Override
    public List<Author> findAllByBookId(Integer bookId) {
        return authorDao.findAllByBookId(bookId);
    }

    @Override
    public List<Author> findAllByIds(List<Integer> ids) {
        return authorDao.findAllByIds(ids);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorDao.findById(id);
    }

    @Override
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    public void delete(Integer id) {
        authorDao.delete(id);
    }
}