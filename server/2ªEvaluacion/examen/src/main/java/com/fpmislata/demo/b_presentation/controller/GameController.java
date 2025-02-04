package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.a_common.utils.Color;
import com.fpmislata.demo.b_presentation.mapper.GameMapper;
import com.fpmislata.demo.b_presentation.model.GameWebModelComplete;
import com.fpmislata.demo.b_presentation.model.GameWebModelSimple;
import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.game.interfaces.GameFindByCodeUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(GameController.ENDPOINT)
public class GameController {

    private final GameFindAllUseCase gameFindAllUseCase;
    private final GameFindByCodeUseCase gameFindByCodeUseCase;
    private final GameCreateUseCase gameCreateUseCase;

    private static final String ENDPOINT = "/api/games";

    @GetMapping()
    public ResponseEntity<List<GameWebModelSimple>> findAll() {
        List<Game> games = gameFindAllUseCase.execute();
        List<GameWebModelSimple> gameWebModels = games
                .stream()
                .map(g -> GameMapper.gameToGameWebModelSimple(g))
                .toList();
        return ResponseEntity.ok(gameWebModels);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<GameWebModelComplete> findById(@PathVariable Integer id) {
    //     Game game = gameFindByIdUseCase.execute(id);
    //     GameWebModelComplete gameWebModel = GameMapper.gameToWebModelComplete(game);
    //     return ResponseEntity.ok(gameWebModel);
    // }

    @GetMapping("/{game_code}")
    public ResponseEntity<GameWebModelComplete> findByCode(@PathVariable("game_code") String code) {
        Color.blue(code);
        Game game = gameFindByCodeUseCase.execute(code);
        GameWebModelComplete gameWebModel = GameMapper.gameToWebModelComplete(game);
        return ResponseEntity.ok(gameWebModel);
    }

    @PostMapping()
    public ResponseEntity<Game> create(@Valid @RequestBody Game game) {
        gameCreateUseCase.execute(game);
        return ResponseEntity.ok(game);
    }
}