package com.fpmislata.demo.c_domain.usecase.game.interfaces;

import com.fpmislata.demo.c_domain.model.Game;

public interface GameFindByIdUseCase {
    Game execute(Integer id);
}