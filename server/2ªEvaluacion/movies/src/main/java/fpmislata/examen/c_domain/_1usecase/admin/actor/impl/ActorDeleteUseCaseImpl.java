package fpmislata.examen.c_domain._1usecase.admin.actor.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.admin.actor.interfaces.ActorDeleteUseCase;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ActorDeleteUseCaseImpl implements ActorDeleteUseCase {

    private final ActorService actorService;

    public void execute(Integer id) {
        actorService.delete(id);
    }
}