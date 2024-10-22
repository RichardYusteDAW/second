package fpmislata.bookstore._3domain.admin._3repInterface;

import java.util.List;

import fpmislata.bookstore._3domain.model.Category;

public interface CategoryRepository {

    List<Category> findAll();

    Category findById(Integer id);

    Integer create(Category category);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}
