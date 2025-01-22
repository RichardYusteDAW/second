package com.fpmislata.demo.d_persistence.zdao.jpa.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.d_persistence.zdao.interfaces.CategoryDao;
import com.fpmislata.demo.d_persistence.zdao.jpa.interfaces.CategoryJpa;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.CategoryMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.CategoryEntity;

import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryJpa categoryJpa;

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntityList = categoryJpa.findAll();
        return CategoryMapper.INSTANCE.toCategoryList(categoryEntityList);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpa
                .findById(id)
                .map(c -> CategoryMapper.INSTANCE.toCategory(c));
    }

    @Override
    public void save(Category category) {
        CategoryEntity categoryEntity = CategoryMapper.INSTANCE.toCategoryEntity(category);
        categoryJpa.save(categoryEntity);
    }

    @Override
    public void delete(Integer id) {
        categoryJpa.deleteById(id);
    }
}