package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.CategoryRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.CategoryJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.CategoryMapper;
import com.fpmislata.demo.d_persistence.jpa.model.CategoryEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpa categoryJpa;

    @Override
    public List<Category> findAll() {
        return CategoryMapper.INSTANCE.toCategoryList(categoryJpa.findAll());
    }

    @Override
    public ListWithCount<Category> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<CategoryEntity> categoryEntityPage = categoryJpa.findAll(pageable);

        List<Category> categoryList = CategoryMapper.INSTANCE.toCategoryList(categoryEntityPage.getContent());
        Integer count = (int) categoryEntityPage.getTotalElements();

        return new ListWithCount<>(categoryList, count);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpa
                .findById(id)
                .map(c -> CategoryMapper.INSTANCE.toCategory(c));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryJpa
                .findByName(name)
                .map(c -> CategoryMapper.INSTANCE.toCategory(c));
    }

    @Override
    public void save(Category category) {
        categoryJpa.save(CategoryMapper.INSTANCE.toCategoryEntity(category));
    }

    @Override
    public void delete(Integer id) {
        categoryJpa.deleteById(id);
    }
}