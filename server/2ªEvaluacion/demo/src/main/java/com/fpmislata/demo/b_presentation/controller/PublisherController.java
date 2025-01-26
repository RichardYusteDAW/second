package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;
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
    public ResponseEntity<List<PublisherSimple>> findAll() {
        List<Publisher> publisherList = publisherFindAllUseCase.execute();
        List<PublisherSimple> publisherSimpleList = PublisherMapper.INSTANCE.toPublisherSimpleList(publisherList);

        return ResponseEntity.ok(publisherSimpleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherComplete> findById(@PathVariable Integer id) {
        Publisher publisher = publisherFindByIdUseCase.execute(id);
        PublisherComplete publisherComplete = PublisherMapper.INSTANCE.toPublisherComplete(publisher);

        return ResponseEntity.ok(publisherComplete);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody PublisherComplete publisherComplete) {
        publisherCreateUseCase.execute(PublisherMapper.INSTANCE.toPublisher(publisherComplete));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
            @Valid @RequestBody PublisherComplete publisherComplete) {
        Publisher publisher = PublisherMapper.INSTANCE.toPublisher(publisherComplete);
        publisher.setId(id);
        publisherUpdateUseCase.execute(publisher);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        publisherDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}