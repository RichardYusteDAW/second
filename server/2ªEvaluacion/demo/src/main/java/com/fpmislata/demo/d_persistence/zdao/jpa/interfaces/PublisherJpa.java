package com.fpmislata.demo.d_persistence.zdao.jpa.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.demo.d_persistence.zdao.jpa.model.PublisherEntity;

public interface PublisherJpa extends JpaRepository<PublisherEntity, Integer> {
    Optional<PublisherEntity> findByName(String name);
}