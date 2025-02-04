package com.fpmislata.demo.c_domain.repository;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Game;

public interface GameRepository {

    List<Game> findAll();

    Optional<Game> findById(Integer id);

    Optional<Game> findByCode(String code);

    void save(Game game);
}