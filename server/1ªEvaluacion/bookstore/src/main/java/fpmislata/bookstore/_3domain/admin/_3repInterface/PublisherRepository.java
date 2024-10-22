package fpmislata.bookstore._3domain.admin._3repInterface;

import java.util.List;

import fpmislata.bookstore._3domain.model.Publisher;

public interface PublisherRepository {

    List<Publisher> findAll();

    Publisher findById(Integer id);

    Integer create(Publisher publisher);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}