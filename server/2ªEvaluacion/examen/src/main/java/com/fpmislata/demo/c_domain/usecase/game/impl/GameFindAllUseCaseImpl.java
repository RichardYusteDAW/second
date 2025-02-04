package com.fpmislata.demo.c_domain.usecase.game.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.service.interfaces.GameService;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GameFindAllUseCaseImpl implements GameFindAllUseCase {

    private final GameService gameService;

    public List<Game> execute() {
        return gameService.findAll();
    }
}