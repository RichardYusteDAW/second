package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Figure;

public interface FigureService {

    List<Figure> findAll();

    Optional<Figure> findById(Integer id);
}