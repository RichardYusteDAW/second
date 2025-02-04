package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Director;
import com.fpmislata.demo.c_domain.repository.DirectorRepository;
import com.fpmislata.demo.c_domain.service.interfaces.DirectorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorRepository.findById(id);
    }
}