package fpmislata.examen.c_domain._1usecase.common.actor.interfaces;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorFindByIdUseCase {
    Actor execute(Integer id);
}