package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.MovieComplete;
import fpmislata.examen.b_presentation.admin.model.MovieSimple;
import fpmislata.examen.c_domain._2service.model.Movie;

@Mapper(uses = { DirectorMapper.class, ActorMapper.class })
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    List<MovieSimple> toMovieSimpleList(List<Movie> movies);

    MovieSimple toMovieSimple(Movie movie);

    MovieComplete toMovieComplete(Movie movie);
}