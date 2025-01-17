package com.fpmislata.demo.d_persistence.zdao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.demo.d_persistence.zdao.impl.model.CategoryEntity;

public interface CategoryJpa extends JpaRepository<CategoryEntity, Integer> {

}