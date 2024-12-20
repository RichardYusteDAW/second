package fpmislata.examen.c_domain._1usecase.common.actor.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindByIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ActorFindByIdUseCaseImpl implements ActorFindByIdUseCase {

    private final ActorService actorService;

    @Override
    public Actor execute(Integer id) {
        return actorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
    }
}