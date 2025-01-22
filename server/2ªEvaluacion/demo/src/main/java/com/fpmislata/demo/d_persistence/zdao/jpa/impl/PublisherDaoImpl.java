package com.fpmislata.demo.d_persistence.zdao.jpa.impl;

import java.util.List;
import java.util.Optional;

import com.fpmislata.demo.a_common.annotation.Dao;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.d_persistence.zdao.interfaces.PublisherDao;
import com.fpmislata.demo.d_persistence.zdao.jpa.interfaces.PublisherJpa;
import com.fpmislata.demo.d_persistence.zdao.jpa.mapper.PublisherMapper;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.PublisherEntity;

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
        return publisherJpa
                .findById(id)
                .map(p -> PublisherMapper.INSTANCE.toPublisher(p));
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