package com.fpmislata.demo.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.d_persistence.zdao.impl.jpa.PublisherJpa;
import com.fpmislata.demo.d_persistence.zdao.impl.mapper.PublisherMapper;
import com.fpmislata.demo.d_persistence.zdao.impl.model.PublisherEntity;
import com.fpmislata.demo.d_persistence.zdao.interfaces.PublisherDao;

import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class PublisherDaoImpl implements PublisherDao {

    private final PublisherJpa publisherJpa;

    @Override
    public List<Publisher> findAll() {
        List<PublisherEntity> publisherEntityList = publisherJpa.findAll();
        return PublisherMapper.INSTANCE.toPublisherList(publisherEntityList);
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherJpa.findById(id).map(p -> PublisherMapper.INSTANCE.toPublisher(p));
        // Optional<PublisherEntity> publisherEntity = publisherJpa.findById(id);
        // if (publisherEntity.isPresent()) {
        //     return Optional.of(PublisherMapper.INSTANCE.toPublisher(publisherEntity.get()));
        // } else {
        //     return Optional.empty();
        // }
    }

    @Override
    public void save(Publisher publisher) {
        PublisherEntity publisherEntity = PublisherMapper.INSTANCE.toPublisherEntity(publisher);
        publisherJpa.save(publisherEntity);
    }

    @Override
    public void delete(Integer id) {
        publisherJpa.deleteById(id);
    }
}