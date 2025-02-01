package com.fpmislata.demo.c_domain.usecase.category.interfaces;

import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface CategoryFindAllWithCountUseCase {
    ListWithCount<Category> execute(Integer page, Integer size);
}