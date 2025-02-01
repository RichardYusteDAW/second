package com.fpmislata.demo.d_persistence.jpa.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpmislata.demo.d_persistence.jpa.model.CategoryEntity;

public interface CategoryJpa extends JpaRepository<CategoryEntity, Integer> {
    @Query(value = "SELECT * FROM categories WHERE name_es = :name OR name_en = :name", nativeQuery = true)
    Optional<CategoryEntity> findByName(String name);
}