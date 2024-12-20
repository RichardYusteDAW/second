package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.d_persistence.zdao.impl.jpa.ActorJpa;
import fpmislata.examen.d_persistence.zdao.impl.mapper.ActorDaoMapper;
import fpmislata.examen.d_persistence.zdao.impl.model.ActorDaoModel;
import fpmislata.examen.d_persistence.zdao.interfaces.ActorDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao {

    private final ActorJpa actorJpa;

    @Override
    public ListWithCount<Actor> findAll(Integer page, Integer size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        // Pageable pageable = PageRequest.of(page, size);
        // Page<Actor> actorPage = actorJpa.findAll(pageable);
        // return actorPage.getContent();
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        Optional<ActorDaoModel> optionalActorDaoModel = actorJpa.findById(id);
        Optional<Actor> optionalActor = optionalActorDaoModel
                .map(actorDaoModel -> ActorDaoMapper.INSTANCE.toActor(actorDaoModel));
        return optionalActor;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Actor save(Actor t) {
        ActorDaoModel actorDaoModel = actorJpa.save(ActorDaoMapper.INSTANCE.toActorDaoModel(t));
        return ActorDaoMapper.INSTANCE.toActor(actorDaoModel);
    }

    @Override
    public List<Actor> findAllByMovieId(Integer movieId) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllByMovieId'");
    }

    @Override
    public List<Actor> findAllById(Integer[] actorsIds) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }
}