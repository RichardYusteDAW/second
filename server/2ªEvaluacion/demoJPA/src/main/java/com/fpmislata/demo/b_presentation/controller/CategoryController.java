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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.CategoryMapper;
import com.fpmislata.demo.b_presentation.model.CategoryWebModel;
import com.fpmislata.demo.b_presentation.model.Paginator;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindAllWithCountUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.category.interfaces.CategoryUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(CategoryController.ENDPOINT)
public class CategoryController {

    private final CategoryFindAllUseCase categoryFindAllUseCase;
    private final CategoryFindAllWithCountUseCase categoryFindAllWithCountUseCase;
    private final CategoryFindByIdUseCase categoryFindByIdUseCase;
    private final CategoryCreateUseCase categoryCreateUseCase;
    private final CategoryUpdateUseCase categoryUpdateUseCase;
    private final CategoryDeleteUseCase categoryDeleteUseCase;

    @Value("${URL}")
    private String URL;
    public static final String ENDPOINT = "/categories";

    @GetMapping()
    public ResponseEntity<List<CategoryWebModel>> findAll() {
        List<Category> categoryList = categoryFindAllUseCase.execute();
        List<CategoryWebModel> categoryWebModelList = CategoryMapper.INSTANCE.toCategoryWebModelList(categoryList);

        return ResponseEntity.ok(categoryWebModelList);
    }

    @GetMapping("/paginator")
    public ResponseEntity<Paginator<CategoryWebModel>> findAllAllWithCount(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        ListWithCount<Category> categoryListWithCount = categoryFindAllWithCountUseCase.execute(page, size);

        List<CategoryWebModel> categoryWebModelList = CategoryMapper.INSTANCE
                .toCategoryWebModelList(categoryListWithCount.getList());
        Integer total = categoryListWithCount.getCount();
        String baseUrl = URL + ENDPOINT;

        Paginator<CategoryWebModel> categoryWebModelPaginator = new Paginator<>(categoryWebModelList, total, page, size,
                baseUrl);

        return ResponseEntity.ok(categoryWebModelPaginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category category = categoryFindByIdUseCase.execute(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Category category) {
        categoryCreateUseCase.execute(category);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
            @Valid @RequestBody Category category) {
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