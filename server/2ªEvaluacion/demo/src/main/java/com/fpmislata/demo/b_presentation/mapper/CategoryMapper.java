package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.CategoryComplete;
import com.fpmislata.demo.b_presentation.model.CategorySimple;
import com.fpmislata.demo.c_domain.model.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryComplete category);

    CategorySimple toCategorySimple(Category category);

    CategoryComplete toCategoryComplete(Category category);

    List<CategorySimple> toCategorySimpleList(List<Category> categoryList);
}