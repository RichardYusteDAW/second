package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Figure;
import com.fpmislata.demo.c_domain.repository.FigureRepository;
import com.fpmislata.demo.c_domain.service.interfaces.FigureService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FigureServiceImpl implements FigureService {
    private final FigureRepository figureRepository;

    @Override
    public List<Figure> findAll() {
        return figureRepository.findAll();
    }

    @Override
    public Optional<Figure> findById(Integer id) {
        return figureRepository.findById(id);
    }
}