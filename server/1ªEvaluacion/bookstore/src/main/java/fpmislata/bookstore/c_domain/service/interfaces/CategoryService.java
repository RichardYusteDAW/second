package fpmislata.bookstore.c_domain.service.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}