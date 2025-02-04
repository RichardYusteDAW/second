package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Figure;

public interface FigureRepository {

    List<Figure> findAll();

    Optional<Figure> findById(Integer id);
}