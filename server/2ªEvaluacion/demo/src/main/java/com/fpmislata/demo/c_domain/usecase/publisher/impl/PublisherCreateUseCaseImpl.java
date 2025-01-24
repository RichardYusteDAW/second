package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherCreateUseCaseImpl implements PublisherCreateUseCase {

    private final PublisherService publisherService;

    @Override
    public void execute(Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherService.findByName(publisher.getName());
        if (publisherOptional.isPresent()) {
            throw new ResourceAlreadyExistsException("Publisher already exists");
        }
        publisherService.create(publisher);
    }
}