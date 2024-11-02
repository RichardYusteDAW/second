package fpmislata.bookstore.c_domain._2service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._2service.interfaces.PublisherService;
import fpmislata.bookstore.c_domain._2service.model.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Override
    public List<Publisher> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Publisher findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Integer create(String name, String slug) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Boolean update(Long id, String name, String slug) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
