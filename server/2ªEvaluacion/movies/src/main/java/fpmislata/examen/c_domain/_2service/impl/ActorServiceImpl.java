package fpmislata.examen.c_domain._2service.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._3repository.ActorRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<Actor> findAllById(List<Actor> actors) {
        Integer[] actorsIds = actors
                .stream()
                .map(actor -> actor.getId())
                .toArray(size -> new Integer[size]);

        List<Actor> actorsFound = actorRepository.findAllById(actorsIds);
        if (actorsFound.size() != actors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        return actorsFound;
    }
}