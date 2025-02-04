package com.fpmislata.demo.d_persistence.jpa.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.d_persistence.jpa.model.GameEntity;

@Mapper(uses = { DirectorMapper.class, FigureMapper.class })
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Named("toGame")
    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characters", ignore = true)
    Game toGame(GameEntity gameEntity);

    Game toGameWithDetails(GameEntity gameEntity);

    GameEntity toGameEntity(Game game);

    @IterableMapping(qualifiedByName = "toGame")
    List<Game> toGameList(List<GameEntity> gameEntityList);

    List<GameEntity> toGameEntityList(List<Game> gameList);
}
