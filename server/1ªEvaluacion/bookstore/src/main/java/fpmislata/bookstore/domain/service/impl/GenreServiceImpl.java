package fpmislata.bookstore.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.service.interfaceSer.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

    @Override
    public List<Genre> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Genre findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Integer create(Long id, String name, String slug) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Boolean update(Long id, String name, String slug) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
