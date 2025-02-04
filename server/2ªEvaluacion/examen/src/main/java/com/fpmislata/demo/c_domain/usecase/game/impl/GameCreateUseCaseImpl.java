package com.fpmislata.demo.c_domain.usecase.game.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.service.interfaces.DirectorService;
import com.fpmislata.demo.c_domain.service.interfaces.FigureService;
import com.fpmislata.demo.c_domain.service.interfaces.GameService;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GameCreateUseCaseImpl implements GameCreateUseCase {

    private final GameService gameService;
    private final DirectorService directorService;
    private final FigureService figureService;

    @Override
    public void execute(Game game) {

        gameService
                .findByCode(game.getGameCode())
                .ifPresent(g -> {
                    throw new ResourceAlreadyExistsException("Game already exists");
                });

        directorService
                .findById(game.getDirector().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));

        List<Integer> charactersIds = game.getCharacters().stream().map(c -> c.getId()).toList();
        charactersIds.forEach(id -> {
            figureService
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
        });

        gameService.create(game);
    }
}