package com.fpmislata.demo.c_domain.usecase.category.interfaces;

import com.fpmislata.demo.c_domain.model.Category;

public interface CategoryFindByIdUseCase {
    Category execute(Integer id);
}
