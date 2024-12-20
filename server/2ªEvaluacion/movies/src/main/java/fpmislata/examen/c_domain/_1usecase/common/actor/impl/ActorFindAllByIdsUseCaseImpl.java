package fpmislata.examen.c_domain._1usecase.common.actor.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindAllByIdsUseCase;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ActorFindAllByIdsUseCaseImpl implements ActorFindAllByIdsUseCase {

    private final ActorService actorService;

    public List<Actor> execute(List<Actor> actors) {
        return actorService.findAllByIds(actors);
    }
}