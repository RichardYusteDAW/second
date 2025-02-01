package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherService {

    List<Publisher> findAll();

    ListWithCount<Publisher> findAll(Integer page, Integer size);

    Optional<Publisher> findById(Integer id);

    Optional<Publisher> findByName(String name);

    void create(Publisher publisher);

    void update(Publisher publisher);

    void delete(Integer id);
}