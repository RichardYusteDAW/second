package fpmislata.examen.c_domain._2service.interfaces;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface DirectorService {

    ListWithCount<Director> findAll(Integer page, Integer size);

    Optional<Director> findByMovieId(Integer movieId);

    Optional<Director> findById(Integer id);

    Director create(Director director);

    Director update(Director director);

    void delete(Integer id);
}