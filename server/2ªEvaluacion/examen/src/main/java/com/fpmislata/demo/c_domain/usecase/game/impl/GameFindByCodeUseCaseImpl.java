package com.fpmislata.demo.c_domain.usecase.game.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.service.interfaces.GameService;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameFindByCodeUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GameFindByCodeUseCaseImpl implements GameFindByCodeUseCase {

    private final GameService gameService;

    @Override
    public Game execute(String code) {
        return gameService
                .findByCode(code)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }
}