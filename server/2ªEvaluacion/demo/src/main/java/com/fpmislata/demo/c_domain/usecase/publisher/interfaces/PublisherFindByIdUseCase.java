package com.fpmislata.demo.c_domain.usecase.publisher.interfaces;

import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherFindByIdUseCase {
    Publisher execute(Integer id);
}
