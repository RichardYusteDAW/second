package fpmislata.bookstore.domain.service._1interfaceSer;

import java.util.List;

import fpmislata.bookstore.domain.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}