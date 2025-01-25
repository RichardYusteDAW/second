package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryDao extends GenericDao<Category> {
    Optional<Category> findByName(String name);
}