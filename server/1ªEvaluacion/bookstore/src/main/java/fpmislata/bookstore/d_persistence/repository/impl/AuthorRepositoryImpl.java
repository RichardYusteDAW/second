package fpmislata.bookstore.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.d_persistence.repository.interfaces.AuthorRepository;
import fpmislata.bookstore.d_persistence.zdao.interfaces.AuthorDao;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDao authorDao;

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public List<Author> findAllById(List<Long> authorIdList) {
        return authorDao.findAllById(authorIdList);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorDao.findById(id);
    }

    @Override
    public Optional<Author> findByBookISBN(Integer ISBN) {
        return authorDao.findByBookISBN(ISBN);
    }

    @Override
    public Long create(Author author) {
        return authorDao.create(author);
    }

    @Override
    public Boolean update(Author author) {
        return authorDao.update(author);
    }

    @Override
    public Boolean delete(Long id) {
        return authorDao.delete(id);
    }

}
