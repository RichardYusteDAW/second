package fpmislata.examen.c_domain._1usecase.common.actor.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorFindAllByIdsUseCase {
    List<Actor> execute(List<Actor> actors);
}