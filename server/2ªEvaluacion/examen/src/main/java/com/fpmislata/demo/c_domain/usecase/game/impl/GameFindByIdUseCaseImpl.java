package com.fpmislata.demo.c_domain.usecase.game.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.service.interfaces.GameService;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GameFindByIdUseCaseImpl implements GameFindByIdUseCase {

    private final GameService gameService;

    @Override
    public Game execute(Integer id) {
        return gameService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found"));
    }
}