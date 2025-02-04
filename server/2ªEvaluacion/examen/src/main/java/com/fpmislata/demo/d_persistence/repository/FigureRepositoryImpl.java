package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Figure;
import com.fpmislata.demo.c_domain.repository.FigureRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.FigureJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.FigureMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FigureRepositoryImpl implements FigureRepository {

    private final FigureJpa figureJpa;

    @Override
    public List<Figure> findAll() {
        return FigureMapper.INSTANCE.toFigureList(figureJpa.findAll());
    }

    @Override
    public Optional<Figure> findById(Integer id) {
        return figureJpa
                .findById(id)
                .map(f -> FigureMapper.INSTANCE.toFigure(f));
    }
}