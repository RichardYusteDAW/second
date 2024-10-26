package fpmislata.bookstore.c_domain.repository;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Category;

public interface CategoryRepository {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Integer create(Category category);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}
