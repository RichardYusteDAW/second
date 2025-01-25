package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Optional<Category> findByName(String name);

    void create(Category Category);

    void update(Category Category);

    void delete(Integer id);
}