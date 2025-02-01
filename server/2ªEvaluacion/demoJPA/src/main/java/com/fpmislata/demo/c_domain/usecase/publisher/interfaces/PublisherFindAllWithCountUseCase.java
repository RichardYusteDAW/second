package com.fpmislata.demo.c_domain.usecase.publisher.interfaces;

import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;

public interface PublisherFindAllWithCountUseCase {
    ListWithCount<Publisher> execute(Integer page, Integer size);
}