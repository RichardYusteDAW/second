package com.fpmislata.demo.d_persistence.zdao.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.CategoryEntity;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryEntity categoryEntity);

    CategoryEntity toCategoryEntity(Category category);

    List<Category> toCategoryList(List<CategoryEntity> categoryEntities);

    List<CategoryEntity> toCategoryEntityList(List<Category> categories);
}