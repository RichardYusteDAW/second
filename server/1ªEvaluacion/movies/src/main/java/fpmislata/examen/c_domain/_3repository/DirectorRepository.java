package fpmislata.examen.c_domain._3repository;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Director;

public interface DirectorRepository {

    List<Director> getAll(Integer page, Integer size);

    Optional<Director> findById(Integer id);

    void delete(Integer id);

    Optional<Integer> save(Director director);
}