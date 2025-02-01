package com.fpmislata.demo.c_domain.usecase.category.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CategoryFindAllUseCaseImpl implements CategoryFindAllUseCase {

    private final CategoryService categoryService;

    @Override
    public List<Category> execute() {
        return categoryService.findAll();
    }
}