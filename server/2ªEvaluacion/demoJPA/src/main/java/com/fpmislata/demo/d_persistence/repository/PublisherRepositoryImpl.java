package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.repository.PublisherRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.PublisherJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.PublisherMapper;
import com.fpmislata.demo.d_persistence.jpa.model.PublisherEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryImpl implements PublisherRepository {

    private final PublisherJpa publisherJpa;

    @Override
    public List<Publisher> findAll() {
        return PublisherMapper.INSTANCE.toPublisherList(publisherJpa.findAll());
    }

    @Override
    public ListWithCount<Publisher> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<PublisherEntity> publisherPage = publisherJpa.findAll(pageable);

        List<Publisher> publisherList = PublisherMapper.INSTANCE.toPublisherList(publisherPage.getContent());
        Integer count = (int) publisherPage.getTotalElements();

        return new ListWithCount<>(publisherList, count);
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherJpa
                .findById(id)
                .map(p -> PublisherMapper.INSTANCE.toPublisher(p));
    }

    @Override
    public Optional<Publisher> findByName(String name) {
        return publisherJpa
                .findByName(name)
                .map(p -> PublisherMapper.INSTANCE.toPublisher(p));
    }

    @Override
    public void save(Publisher publisher) {
        publisherJpa.save(PublisherMapper.INSTANCE.toPublisherEntity(publisher));
    }

    @Override
    public void delete(Integer id) {
        publisherJpa.deleteById(id);
    }
}