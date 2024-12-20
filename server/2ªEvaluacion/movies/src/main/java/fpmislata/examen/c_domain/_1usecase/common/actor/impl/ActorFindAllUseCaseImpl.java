package fpmislata.examen.c_domain._1usecase.common.actor.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ActorFindAllUseCaseImpl implements ActorFindAllUseCase {

    private final ActorService actorService;

    @Override
    public ListWithCount<Actor> execute(Integer page, Integer size) {
        return actorService.findAll(page, size);
    }
}