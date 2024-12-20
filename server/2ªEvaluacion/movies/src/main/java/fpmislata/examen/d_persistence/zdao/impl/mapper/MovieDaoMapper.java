package fpmislata.examen.d_persistence.zdao.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.d_persistence.zdao.impl.model.MovieDaoModel;

@Mapper(uses = { DirectorDaoMapper.class, ActorDaoMapper.class })
public interface MovieDaoMapper {

    MovieDaoMapper INSTANCE = Mappers.getMapper(MovieDaoMapper.class);

    @Mapping(source = "directorDaoModel", target = "director")
    @Mapping(source = "actorDaoModelList", target = "actors")
    Movie toMovie(MovieDaoModel movieDaoModel);

    @Mapping(source = "director", target = "directorDaoModel")
    @Mapping(source = "actors", target = "actorDaoModelList")
    MovieDaoModel toMovieDaoModel(Movie movie);
}