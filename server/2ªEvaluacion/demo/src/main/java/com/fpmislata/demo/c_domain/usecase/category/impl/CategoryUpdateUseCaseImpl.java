package com.fpmislata.demo.c_domain.usecase.category.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryUpdateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryUpdateUseCaseImpl implements CategoryUpdateUseCase {

    private final CategoryService categoryService;

    @Override
    public void execute(Category category) {
        categoryService.update(category);
    }
}