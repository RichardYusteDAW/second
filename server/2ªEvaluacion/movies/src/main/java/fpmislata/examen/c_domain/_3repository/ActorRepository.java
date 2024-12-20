package fpmislata.examen.c_domain._3repository;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface ActorRepository {

    ListWithCount<Actor> findAll(Integer page, Integer size);

    List<Actor> findAllByMovieId(Integer movieId);

    List<Actor> findAllByIds(List<Integer> actorsIds);

    Optional<Actor> findById(Integer id);

    Actor create(Actor actor);

    Actor update(Actor actor);

    void delete(Integer id);
}