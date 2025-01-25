package com.fpmislata.demo.c_domain.usecase.category.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryFindByIdUseCaseImpl implements CategoryFindByIdUseCase {

    private final CategoryService categoryService;

    @Override
    public Category execute(Integer id) {
        return categoryService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}