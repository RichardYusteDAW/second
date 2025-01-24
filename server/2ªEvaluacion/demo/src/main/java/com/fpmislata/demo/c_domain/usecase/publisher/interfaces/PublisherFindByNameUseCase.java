package com.fpmislata.demo.c_domain.usecase.publisher.interfaces;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherFindByNameUseCase {
    Publisher execute(String name);
}