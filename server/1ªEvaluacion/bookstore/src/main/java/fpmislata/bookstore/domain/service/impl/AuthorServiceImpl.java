package fpmislata.bookstore.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.service.interfaceSer.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Override
    public List<Author> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Author findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Integer create(long id, String name, String nationality, String biography, int birthYear, int deathYear) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography, int birthYear, int deathYear) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
