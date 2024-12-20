package fpmislata.examen.c_domain._1usecase.common.actor.interfaces;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface ActorFindAllUseCase {
    ListWithCount<Actor> execute(Integer page, Integer size);
}
