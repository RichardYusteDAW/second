package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.PublisherMapper;
import com.fpmislata.demo.b_presentation.model.PublisherComplete;
import com.fpmislata.demo.b_presentation.model.PublisherSimple;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherUpdateUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(PublisherController.ENDPOINT)
public class PublisherController {

    private final PublisherFindAllUseCase publisherFindAllUseCase;
    private final PublisherFindByIdUseCase publisherFindByIdUseCase;
    private final PublisherCreateUseCase publisherCreateUseCase;
    private final PublisherUpdateUseCase publisherUpdateUseCase;
    private final PublisherDeleteUseCase publisherDeleteUseCase;

    @Value("${url}")
    private String url;
    public static final String ENDPOINT = "/publishers";

    @GetMapping()
    public List<PublisherSimple> findAll() {
        List<Publisher> publisherList = publisherFindAllUseCase.execute();
        return PublisherMapper.INSTANCE.toPublisherSimpleList(publisherList);
    }

    @GetMapping("/{id}")
    public PublisherComplete findById(@PathVariable String id) {
        Publisher publisher = publisherFindByIdUseCase.execute(Integer.parseInt(id));
        return PublisherMapper.INSTANCE.toPublisherComplete(publisher);
    }

    @PostMapping()
    public void create(@RequestBody PublisherComplete publisherComplete) {
        publisherCreateUseCase.execute(PublisherMapper.INSTANCE.toPublisher(publisherComplete));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Publisher publisher) {
        publisher.setId(Integer.parseInt(id));
        publisherUpdateUseCase.execute(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        publisherDeleteUseCase.execute(Integer.parseInt(id));
    }
}