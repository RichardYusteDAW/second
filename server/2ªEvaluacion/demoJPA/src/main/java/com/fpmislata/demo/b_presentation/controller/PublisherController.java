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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.PublisherMapper;
import com.fpmislata.demo.b_presentation.model.Paginator;
import com.fpmislata.demo.b_presentation.model.PublisherWebModel;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindAllWithCountUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.publisher.interfaces.PublisherUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(PublisherController.ENDPOINT)
public class PublisherController {

    private final PublisherFindAllUseCase publisherFindAllUseCase;
    private final PublisherFindAllWithCountUseCase publisherFindAllWithCountUseCase;
    private final PublisherFindByIdUseCase publisherFindByIdUseCase;
    private final PublisherCreateUseCase publisherCreateUseCase;
    private final PublisherUpdateUseCase publisherUpdateUseCase;
    private final PublisherDeleteUseCase publisherDeleteUseCase;

    @Value("${URL}")
    private String URL;
    public static final String ENDPOINT = "/publishers";

    @GetMapping()
    public ResponseEntity<List<PublisherWebModel>> findAll() {
        List<Publisher> publisherList = publisherFindAllUseCase.execute();
        List<PublisherWebModel> publisherWePublisherWebModelList = PublisherMapper.INSTANCE
                .toPublisherWebModelList(publisherList);

        return ResponseEntity.ok(publisherWePublisherWebModelList);
    }

    @GetMapping("/paginator")
    public ResponseEntity<Paginator<PublisherWebModel>> findAllAllWithCount(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        ListWithCount<Publisher> publisherListWithCount = publisherFindAllWithCountUseCase.execute(page, size);

        List<PublisherWebModel> publisherWePublisherWebModelList = PublisherMapper.INSTANCE
                .toPublisherWebModelList(publisherListWithCount.getList());
        Integer total = publisherListWithCount.getCount();
        String baseUrl = URL + ENDPOINT;

        Paginator<PublisherWebModel> paginator = new Paginator<>(publisherWePublisherWebModelList, total, page, size,
                baseUrl);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Integer id) {
        Publisher publisher = publisherFindByIdUseCase.execute(id);

        return ResponseEntity.ok(publisher);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Publisher publisher) {
        publisherCreateUseCase.execute(publisher);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Publisher publisher) {
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