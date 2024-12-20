package fpmislata.examen.c_domain._2service.interfaces;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieService {

    ListWithCount<Movie> findAll(Integer page, Integer size);

    Optional<Movie> findById(Integer id);

    void delete(Integer id);

    Movie save(Movie movie);
}