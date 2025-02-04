package com.fpmislata.demo.d_persistence.jpa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.demo.d_persistence.jpa.model.DirectorEntity;

public interface DirectorJpa extends JpaRepository<DirectorEntity, Integer> {
}