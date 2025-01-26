package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CategorySimple>> findAll() {
        List<Category> categoryList = categoryFindAllUseCase.execute();
        List<CategorySimple> categorySimpleList = CategoryMapper.INSTANCE.toCategorySimpleList(categoryList);

        return ResponseEntity.ok(categorySimpleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryComplete> findById(@PathVariable Integer id) {
        Category category = categoryFindByIdUseCase.execute(id);
        CategoryComplete categoryComplete = CategoryMapper.INSTANCE.toCategoryComplete(category);

        return ResponseEntity.ok(categoryComplete);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody CategoryComplete categoryComplete) {
        categoryCreateUseCase.execute(CategoryMapper.INSTANCE.toCategory(categoryComplete));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
            @Valid @RequestBody CategoryComplete categoryComplete) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryComplete);
        category.setId(id);
        categoryUpdateUseCase.execute(category);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}