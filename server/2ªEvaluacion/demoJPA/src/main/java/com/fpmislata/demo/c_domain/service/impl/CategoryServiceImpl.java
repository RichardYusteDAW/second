package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.CategoryRepository;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ListWithCount<Category> findAll(Integer page, Integer size) {
        return categoryRepository.findAll(page, size);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }
}