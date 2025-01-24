package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherUpdateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherUpdateUseCaseImpl implements PublisherUpdateUseCase {

    private final PublisherService publisherService;

    @Override
    public void execute(Publisher publisher) {
        publisherService
                .findById(publisher.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));

        publisherService.update(publisher);
    }
}