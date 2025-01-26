package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.CategoryMapper;
import com.fpmislata.demo.b_presentation.model.CategoryComplete;
import com.fpmislata.demo.b_presentation.model.CategorySimple;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(CategoryController.ENDPOINT)
public class CategoryController {

    private final CategoryFindAllUseCase categoryFindAllUseCase;
    private final CategoryFindByIdUseCase categoryFindByIdUseCase;
    private final CategoryCreateUseCase categoryCreateUseCase;
    private final CategoryUpdateUseCase categoryUpdateUseCase;
    private final CategoryDeleteUseCase categoryDeleteUseCase;

    @Value("${url}")
    private String url;
    public static final String ENDPOINT = "/categories";

    @GetMapping()
    public List<CategorySimple> findAll() {
        List<Category> categoryList = categoryFindAllUseCase.execute();
        return CategoryMapper.INSTANCE.toCategorySimpleList(categoryList);
    }

    @GetMapping("/{id}")
    public CategoryComplete findById(@PathVariable Integer id) {
        Category category = categoryFindByIdUseCase.execute(id);
        return CategoryMapper.INSTANCE.toCategoryComplete(category);
    }

    @PostMapping()
    public void create(@Valid @RequestBody CategoryComplete categoryComplete) {
        categoryCreateUseCase.execute(CategoryMapper.INSTANCE.toCategory(categoryComplete));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody CategoryComplete categoryComplete) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryComplete);
        category.setId(id);
        categoryUpdateUseCase.execute(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryDeleteUseCase.execute(id);
    }
}