package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.repository.PublisherRepository;
import com.fpmislata.demo.d_persistence.zdao.interfaces.PublisherDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryImpl implements PublisherRepository {

    private final PublisherDao publisherDao;

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherDao.findById(id);
    }

    @Override
    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    @Override
    public void delete(Integer id) {
        publisherDao.delete(id);
    }
}