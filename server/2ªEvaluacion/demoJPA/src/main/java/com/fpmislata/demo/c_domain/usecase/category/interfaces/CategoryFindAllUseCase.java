package com.fpmislata.demo.c_domain.usecase.category.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryFindAllUseCase {
    List<Category> execute();
}