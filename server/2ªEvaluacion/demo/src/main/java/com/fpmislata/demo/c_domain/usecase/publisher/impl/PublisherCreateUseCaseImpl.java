package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
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
        publisherService.create(publisher);
    }
}