package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Director;

public interface DirectorRepository {

    List<Director> findAll();

    Optional<Director> findById(Integer id);
}