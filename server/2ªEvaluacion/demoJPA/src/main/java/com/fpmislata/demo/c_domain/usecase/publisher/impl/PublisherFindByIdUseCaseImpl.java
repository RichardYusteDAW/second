package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindByIdUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherFindByIdUseCaseImpl implements PublisherFindByIdUseCase {

    private final PublisherService publisherService;

    @Override
    public Publisher execute(Integer id) {
        return publisherService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));
    }
}