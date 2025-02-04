package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Director;

public interface DirectorService {

    List<Director> findAll();

    Optional<Director> findById(Integer id);
}