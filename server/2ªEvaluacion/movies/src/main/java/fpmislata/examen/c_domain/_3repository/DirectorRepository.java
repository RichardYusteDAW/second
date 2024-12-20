package fpmislata.examen.c_domain._3repository;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface DirectorRepository {

    ListWithCount<Director> findAll(Integer page, Integer size);

    Optional<Director> findByMovieId(Integer movieId);

    Optional<Director> findById(Integer id);

    Director save(Director director);

    void delete(Integer id);
}