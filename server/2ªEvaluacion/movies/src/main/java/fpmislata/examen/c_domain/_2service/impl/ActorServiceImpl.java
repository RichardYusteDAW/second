package fpmislata.examen.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._2service.interfaces.ActorService;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._3repository.ActorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public ListWithCount<Actor> findAll(Integer page, Integer size) {
        return actorRepository.findAll(page, size);
    }

    @Override
    public List<Actor> findAllByMovieId(Integer movieId) {
        return actorRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<Actor> findAllByIds(List<Actor> actors) {
        List<Integer> actorsIds = actors
                .stream()
                .map(actor -> actor.getId())
                .toList();

        List<Actor> actorsFound = actorRepository.findAllByIds(actorsIds);
        if (actorsFound.size() != actors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        return actorsFound;
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        return actorRepository.findById(id);
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.create(actor);
    }

    @Override
    public Actor update(Actor actor) {
        return actorRepository.update(actor);
    }

    @Override
    public void delete(Integer id) {
        actorRepository.delete(id);
    }
}