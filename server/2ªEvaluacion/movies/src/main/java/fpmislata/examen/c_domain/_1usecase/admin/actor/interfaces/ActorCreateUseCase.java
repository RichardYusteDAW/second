package fpmislata.examen.c_domain._1usecase.admin.actor.interfaces;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorCreateUseCase {
    Actor execute(Actor actor);
}