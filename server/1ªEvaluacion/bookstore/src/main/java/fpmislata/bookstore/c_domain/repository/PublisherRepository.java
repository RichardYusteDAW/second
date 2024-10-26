package fpmislata.bookstore.c_domain.repository;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Publisher;

public interface PublisherRepository {

    List<Publisher> findAll();

    Optional<Publisher> findById(Integer id);

    Integer create(Publisher publisher);

    Boolean update(Publisher publisher);

    Boolean delete(Integer id);
}