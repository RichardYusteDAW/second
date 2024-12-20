package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.ActorSimple;
import fpmislata.examen.c_domain._2service.model.Actor;

@Mapper
public interface ActorMapper {

        ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

        List<ActorSimple> toActorSimpleList(List<Actor> Actors);

        ActorSimple toActorSimple(Actor Actor);
}