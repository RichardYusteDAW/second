package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
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
    public Publisher findById(Integer id) {
        return publisherRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));
    }

    @Override
    public void create(Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(publisher.getId());
        if (publisherOptional.isPresent()) {
            throw new ResourceAlreadyExistsException("Publisher already exists");
        }

        publisherRepository.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        findById(publisher.getId());
        publisherRepository.save(publisher);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        publisherRepository.delete(id);
    }
}