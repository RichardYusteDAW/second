package com.fpmislata.demo.d_persistence.zdao.jpa.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.d_persistence.zdao.interfaces.AuthorDao;
import com.fpmislata.demo.d_persistence.zdao.jpa.interfaces.AuthorJpa;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.AuthorMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.AuthorEntity;

import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorJpa authorJpa;

    @Override
    public List<Author> findAll() {
        List<AuthorEntity> authorEntityList = authorJpa.findAll();
        return AuthorMapper.INSTANCE.toAuthorList(authorEntityList);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorJpa
                .findById(id)
                .map(a -> AuthorMapper.INSTANCE.toAuthor(a));
    }

    @Override
    public void save(Author author) {
        authorJpa.save(AuthorMapper.INSTANCE.toAuthorEntity(author));
    }

    @Override
    public void delete(Integer id) {
        authorJpa.deleteById(id);
    }

    @Override
    public List<Author> findAllByIsbn(String isbn) {
        List<AuthorEntity> authorEntityList = authorJpa.findAllByIsbn(isbn);
        return AuthorMapper.INSTANCE.toAuthorList(authorEntityList);
    }

    @Override
    public List<Author> findAllByBookId(Integer bookId) {
        List<AuthorEntity> authorEntityList = authorJpa.findAllByBookId(bookId);
        return AuthorMapper.INSTANCE.toAuthorList(authorEntityList);
    }

    @Override
    public List<Author> findAllByIds(List<Integer> ids) {
        List<AuthorEntity> authorEntityList = authorJpa.findAllByIds(ids);
        return AuthorMapper.INSTANCE.toAuthorList(authorEntityList);
    }
}
