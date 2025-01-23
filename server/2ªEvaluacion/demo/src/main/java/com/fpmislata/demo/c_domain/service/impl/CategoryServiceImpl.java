package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Category;
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
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public void create(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
        if (categoryOptional.isPresent()) {
            throw new ResourceNotFoundException("Category already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        findById(category.getId());
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        categoryRepository.delete(id);
    }
}