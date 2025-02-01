package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindAllUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherFindAllUseCaseImpl implements PublisherFindAllUseCase {

    private final PublisherService publisherService;

    @Override
    public List<Publisher> execute() {
        return publisherService.findAll();
    }
}