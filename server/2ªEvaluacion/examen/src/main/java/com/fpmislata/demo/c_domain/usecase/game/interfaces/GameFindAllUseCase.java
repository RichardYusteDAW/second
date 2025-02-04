package com.fpmislata.demo.c_domain.usecase.game.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Game;

public interface GameFindAllUseCase {
    List<Game> execute();
}