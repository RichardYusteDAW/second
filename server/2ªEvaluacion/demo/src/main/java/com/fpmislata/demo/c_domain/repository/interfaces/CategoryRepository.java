package com.fpmislata.demo.c_domain.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryRepository {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void save(Category category);

    void delete(Integer id);
}
