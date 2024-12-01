package fpmislata.examen.c_domain._3repository;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieRepository {

    List<Movie> getAll(Integer page, Integer size);

    Optional<Movie> findById(Integer id);

    void delete(Integer id);

    Optional<Integer> save(Movie movie);

    Integer count();
}