package fpmislata.bookstore._3domain.admin._2service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore._3domain.admin._2service._1interfaceSer.GenreService;
import fpmislata.bookstore._3domain.model.Genre;

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
