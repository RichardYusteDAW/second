package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._3repository.ActorRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.ActorDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ActorRepositoryImpl implements ActorRepository {

    private final ActorDao actorDao;

    @Override
    public ListWithCount<Actor> findAll(Integer page, Integer size) {
        return actorDao.findAll(page, size);
    }

    @Override
    public List<Actor> findAllByMovieId(Integer movieId) {
        return actorDao.findAllByMovieId(movieId);
    }

    public List<Actor> findAllByIds(List<Integer> actorsIds) {
        return actorDao.findAllByIds(actorsIds);
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        return actorDao.findById(id);
    }

    @Override
    public Actor create(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public Actor update(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public void delete(Integer id) {
        actorDao.delete(id);
    }
}