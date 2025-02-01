package com.fpmislata.demo.c_domain.usecase.category.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindAllWithCountUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryFindAllWithCountUseCaseImpl implements CategoryFindAllWithCountUseCase {

    private final CategoryService categoryService;

    @Override
    public ListWithCount<Category> execute(Integer page, Integer size) {
        return categoryService.findAll(page, size);
    }
}