package com.fpmislata.demo.d_persistence.jpa.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.demo.d_persistence.jpa.model.GameEntity;

public interface GameJpa extends JpaRepository<GameEntity, Integer> {

    Optional<GameEntity> findByGameCode(String gameCode);
}