package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherDeleteUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherDeleteUseCaseImpl implements PublisherDeleteUseCase {

    private final PublisherService publisherService;

    @Override
    public void execute(Integer id) {
        publisherService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));

        publisherService.delete(id);
    }
}