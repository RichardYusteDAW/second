package fpmislata.bookstore._3domain.admin.service._1interfaceSer;

import java.util.List;

import fpmislata.bookstore._3domain.model.Publisher;

public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}