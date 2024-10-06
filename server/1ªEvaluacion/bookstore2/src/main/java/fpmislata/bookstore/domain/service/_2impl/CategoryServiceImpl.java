package fpmislata.bookstore.domain.service._2impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.service._1interfaceSer.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Category findById(Integer id) {
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
