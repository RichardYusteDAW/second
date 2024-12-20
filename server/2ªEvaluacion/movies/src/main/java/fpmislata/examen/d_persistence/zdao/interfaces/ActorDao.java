package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorDao extends GenericDao<Actor> {

    List<Actor> findAllByMovieId(Integer movieId);

    List<Actor> findAllByIds(List<Integer> actorsIds);
}