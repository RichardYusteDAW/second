package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.Game;
import com.fpmislata.demo.c_domain.repository.GameRepository;
import com.fpmislata.demo.c_domain.service.interfaces.GameService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> findById(Integer id) {
        return gameRepository.findById(id);
    }

    @Override
    public Optional<Game> findByCode(String code) {
        return gameRepository.findByCode(code);
    }

    @Override
    public void create(Game game) {
        gameRepository.save(game);
    }
}