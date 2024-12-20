package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        Pageable pageable = PageRequest.of(page, size);
        Page<ActorDaoModel> actorDaoModelPage = actorJpa.findAll(pageable);

        List<Actor> actorList = actorDaoModelPage
                .stream()
                .map(actorDaoModel -> ActorDaoMapper.INSTANCE.toActor(actorDaoModel))
                .toList();

        return new ListWithCount<>(actorList, actorDaoModelPage.getTotalElements());
    }

    @Override
    public List<Actor> findAllByMovieId(Integer movieId) {
        return actorJpa.findAllByMovieId(movieId)
                .stream()
                .map(actorDaoModel -> ActorDaoMapper.INSTANCE.toActor(actorDaoModel))
                .toList();
    }

    @Override
    public List<Actor> findAllByIds(List<Integer> actorsIds) {
        return actorJpa.findAllByIds(actorsIds)
                .stream()
                .map(actorDaoModel -> ActorDaoMapper.INSTANCE.toActor(actorDaoModel))
                .toList();
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        Optional<ActorDaoModel> optionalActorDaoModel = actorJpa.findById(id);
        Optional<Actor> optionalActor = optionalActorDaoModel
                .map(actorDaoModel -> ActorDaoMapper.INSTANCE.toActor(actorDaoModel));
        return optionalActor;
    }

    @Override
    public Actor save(Actor t) {
        ActorDaoModel actorDaoModel = actorJpa.save(ActorDaoMapper.INSTANCE.toActorDaoModel(t));
        return ActorDaoMapper.INSTANCE.toActor(actorDaoModel);
    }

    @Override
    public void delete(Integer id) {
        actorJpa.deleteById(id);
    }
}