package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    void save(Category Category);

    void delete(Integer id);
}