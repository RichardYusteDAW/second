package fpmislata.bookstore.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.repository.AuthorRepository;
import fpmislata.bookstore.d_persistence.zdao.interfaces.AuthorDao;
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
    public Optional<Author> findById(Integer id) {
        return authorDao.findById(id);
    }

    @Override
    public Optional<Author> findByBookISBN(Integer ISBN) {
        return authorDao.findByBookISBN(ISBN);
    }

    @Override
    public Integer create(Author author) {
        return authorDao.create(author);
    }

    @Override
    public Boolean update(Integer id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {
        return authorDao.update(id, name, nationality, biographyEn, biographyEs, birthYear, deathYear);
    }

    @Override
    public Boolean delete(Integer id) {
        return authorDao.delete(id);
    }

}
