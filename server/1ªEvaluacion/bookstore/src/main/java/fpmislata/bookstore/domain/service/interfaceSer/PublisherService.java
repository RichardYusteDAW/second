package fpmislata.bookstore.domain.service.interfaceSer;

import java.util.List;

import fpmislata.bookstore.domain.model.Publisher;

public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}