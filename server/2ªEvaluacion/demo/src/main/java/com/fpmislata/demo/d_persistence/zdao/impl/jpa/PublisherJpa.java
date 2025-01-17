package com.fpmislata.demo.d_persistence.zdao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.demo.d_persistence.zdao.impl.model.PublisherEntity;

public interface PublisherJpa extends JpaRepository<PublisherEntity, Integer> {
}