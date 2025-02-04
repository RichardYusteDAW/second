package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.repository.GameRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.GameJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.GameMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepository {

    private final GameJpa gameJpa;

    @Override
    public List<Game> findAll() {
        return GameMapper.INSTANCE.toGameList(gameJpa.findAll());
    }

    @Override
    public Optional<Game> findById(Integer id) {
        return gameJpa
                .findById(id)
                .map(g -> GameMapper.INSTANCE.toGameWithDetails(g));
    }

    @Override
    public Optional<Game> findByCode(String code) {
        return gameJpa
                .findByGameCode(code)
                .map(g -> GameMapper.INSTANCE.toGameWithDetails(g));
    }

    @Override
    public void save(Game game) {
        gameJpa.save(GameMapper.INSTANCE.toGameEntity(game));
    }
}