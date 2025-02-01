package com.fpmislata.demo.c_domain.usecase.publisher.impl;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindAllWithCountUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PublisherFindAllWithCountUseCaseImpl implements PublisherFindAllWithCountUseCase {

    private final PublisherService publisherService;

    @Override
    public ListWithCount<Publisher> execute(Integer page, Integer size) {
        return publisherService.findAll(page, size);
    }
}