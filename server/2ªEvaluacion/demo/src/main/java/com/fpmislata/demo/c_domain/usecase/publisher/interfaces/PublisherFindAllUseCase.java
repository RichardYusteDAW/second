package com.fpmislata.demo.c_domain.usecase.publisher.interfaces;

import java.util.List;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherFindAllUseCase {
    List<Publisher> execute();
}