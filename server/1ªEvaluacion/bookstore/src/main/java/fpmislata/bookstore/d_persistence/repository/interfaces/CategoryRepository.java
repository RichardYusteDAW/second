package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Category;

public interface CategoryRepository {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Integer create(Category category);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}
