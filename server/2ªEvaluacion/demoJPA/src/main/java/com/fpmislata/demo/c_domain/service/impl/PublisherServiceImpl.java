package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.repository.PublisherRepository;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public ListWithCount<Publisher> findAll(Integer page, Integer size) {
        return publisherRepository.findAll(page, size);
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Optional<Publisher> findByName(String name) {
        return publisherRepository.findByName(name);
    }

    @Override
    public void create(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void delete(Integer id) {
        publisherRepository.delete(id);
    }
}