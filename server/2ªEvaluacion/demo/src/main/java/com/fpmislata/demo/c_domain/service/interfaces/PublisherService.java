package com.fpmislata.demo.c_domain.service.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    public void checkIfPublisherAlreadyExists(Integer id);

    void create(Publisher publisher);

    void update(Publisher publisher);

    void delete(Integer id);
}