package fpmislata.examen.d_persistence.zdao.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.d_persistence.zdao.impl.model.ActorDaoModel;

@Mapper
public interface ActorDaoMapper {

    ActorDaoMapper INSTANCE = Mappers.getMapper(ActorDaoMapper.class);

    Actor toActor(ActorDaoModel actorDaoModel);

    ActorDaoModel toActorDaoModel(Actor actor);
}