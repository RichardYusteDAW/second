package fpmislata.examen.c_domain._2service.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Director;

public interface DirectorService {

    List<Director> getAll(Integer page, Integer size);

    Optional<Director> findById(Integer id);

    void delete(Integer id);

    Optional<Integer> create(Director director);

    Optional<Integer> update(Director director);
}