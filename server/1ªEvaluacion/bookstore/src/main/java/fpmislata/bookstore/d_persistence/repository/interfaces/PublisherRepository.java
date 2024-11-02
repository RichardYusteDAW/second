package fpmislata.bookstore.d_persistence.repository.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain._2service.model.Publisher;

public interface PublisherRepository {

    List<Publisher> findAll();

    Optional<Publisher> findById(Integer id);

    Integer create(Publisher publisher);

    Boolean update(Publisher publisher);

    Boolean delete(Integer id);
}