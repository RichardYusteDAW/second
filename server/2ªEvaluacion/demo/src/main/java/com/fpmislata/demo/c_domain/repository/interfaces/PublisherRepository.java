package com.fpmislata.demo.c_domain.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherRepository {

    List<Publisher> findAll();

    Optional<Publisher> findById(Integer id);

    void save(Publisher publisher);

    void delete(Integer id);
}