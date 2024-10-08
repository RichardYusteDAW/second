package fpmislata.bookstore.domain.service._3interfaceRep;

import java.util.List;

import fpmislata.bookstore.domain.model.Publisher;

public interface PublisherRepository {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    Integer create(Publisher publisher);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}