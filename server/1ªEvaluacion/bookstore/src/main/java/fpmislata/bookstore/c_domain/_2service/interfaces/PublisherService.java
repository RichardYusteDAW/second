package fpmislata.bookstore.c_domain._2service.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Publisher;

public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    Integer create(String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}