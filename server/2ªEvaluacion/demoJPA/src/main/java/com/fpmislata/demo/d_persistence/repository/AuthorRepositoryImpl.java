package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.AuthorRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.AuthorJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.AuthorMapper;
import com.fpmislata.demo.d_persistence.jpa.model.AuthorEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorJpa authorJpa;

    @Override
    public List<Author> findAll() {
        return AuthorMapper.INSTANCE.toAuthorList(authorJpa.findAll());
    }

    @Override
    public ListWithCount<Author> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<AuthorEntity> authorEntityPage = authorJpa.findAll(pageable);

        List<Author> authorList = AuthorMapper.INSTANCE.toAuthorList(authorEntityPage.getContent());
        Integer count = (int) authorEntityPage.getTotalElements();

        return new ListWithCount<>(authorList, count);
    }

    @Override
    public List<Author> findAllByIsbn(String isbn) {
        return AuthorMapper.INSTANCE.toAuthorList(authorJpa.findAllByIsbn(isbn));
    }

    @Override
    public List<Author> findAllByBookId(Integer bookId) {
        return AuthorMapper.INSTANCE.toAuthorList(authorJpa.findAllByBookId(bookId));
    }

    @Override
    public List<Author> findAllByIds(List<Integer> ids) {
        return AuthorMapper.INSTANCE.toAuthorList(authorJpa.findAllByIds(ids));
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorJpa
                .findById(id)
                .map(a -> AuthorMapper.INSTANCE.toAuthor(a));
    }

    @Override
    public Optional<Author> findByName(String name) {
        return authorJpa
                .findByName(name)
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
}