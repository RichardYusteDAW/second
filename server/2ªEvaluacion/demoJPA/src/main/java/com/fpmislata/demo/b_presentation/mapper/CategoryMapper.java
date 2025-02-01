package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.CategoryWebModel;
import com.fpmislata.demo.c_domain.model.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryWebModel toCategoryWebModel(Category category);

    List<CategoryWebModel> toCategoryWebModelList(List<Category> categoryList);
}