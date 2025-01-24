package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherDao extends GenericDao<Publisher> {
    Optional<Publisher> findByName(String name);
}