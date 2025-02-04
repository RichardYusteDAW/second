package com.fpmislata.demo.b_presentation.mapper;

import com.fpmislata.demo.b_presentation.model.GameWebModelComplete;
import com.fpmislata.demo.b_presentation.model.GameWebModelSimple;
import com.fpmislata.demo.c_domain.model.Game;

public class GameMapper {

    public static GameWebModelSimple gameToGameWebModelSimple(Game game) {
        GameWebModelSimple gameWebModel = new GameWebModelSimple();
        gameWebModel.setTitle(game.getTitle());
        gameWebModel.setLink("http://localhost:8080/api/games/" + game.getGameCode());
        return gameWebModel;
    }

    public static GameWebModelComplete gameToWebModelComplete(Game game) {
        GameWebModelComplete gameWebModel = new GameWebModelComplete();
        gameWebModel.setGameCode(game.getGameCode());
        gameWebModel.setTitle(game.getTitle());
        gameWebModel.setReleaseYear(game.getReleaseYear());
        gameWebModel.setDescription(game.getDescription());
        gameWebModel.setDirector(DirectorMapper.directorToDirectorWebModel(game.getDirector()));
        gameWebModel.setCharacters(game.getCharacters().stream().map(FigureMapper::figureToFigureWebModel).toList());
        return gameWebModel;
    }
}