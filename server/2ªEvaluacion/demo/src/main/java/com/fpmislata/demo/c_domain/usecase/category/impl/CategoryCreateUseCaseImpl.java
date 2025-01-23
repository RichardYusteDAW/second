package com.fpmislata.demo.c_domain.usecase.category.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryCreateUseCaseImpl implements CategoryCreateUseCase {

    private final CategoryService categoryService;

    @Override
    public void execute(Category category) {
        categoryService.create(category);
    }
}