package fpmislata.examen.c_domain._3repository;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieRepository {

    ListWithCount<Movie> findAll(Integer page, Integer size);

    Optional<Movie> findById(Integer id);

    void delete(Integer id);

    Movie save(Movie movie);
}