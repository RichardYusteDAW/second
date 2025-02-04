package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Game;

public interface GameService {

    List<Game> findAll();

    Optional<Game> findById(Integer id);

    Optional<Game> findByCode(String code);

    void create(Game game);
}