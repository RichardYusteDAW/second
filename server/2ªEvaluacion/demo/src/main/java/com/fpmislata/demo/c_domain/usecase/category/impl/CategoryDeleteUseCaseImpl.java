package com.fpmislata.demo.c_domain.usecase.category.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryDeleteUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryDeleteUseCaseImpl implements CategoryDeleteUseCase {

    private final CategoryService categoryService;

    @Override
    public void execute(Integer id) {
        categoryService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryService.delete(id);
    }
}