package fpmislata.examen.c_domain._1usecase.common.actor.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindAllByMovieIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ActorFindAllByMovieIdUseCaseImpl implements ActorFindAllByMovieIdUseCase {

    private final ActorService actorService;

    public List<Actor> execute(Integer movieId) {
        return actorService.findAllByMovieId(movieId);
    }
}