package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface CategoryRepository {

    List<Category> findAll();

    ListWithCount<Category> findAll(Integer page, Integer size);

    Optional<Category> findById(Integer id);

    Optional<Category> findByName(String name);

    void save(Category category);

    void delete(Integer id);
}