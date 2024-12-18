package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.MovieCollection;
import fpmislata.examen.b_presentation.admin.model.MovieDetail;
import fpmislata.examen.c_domain._2service.model.Movie;

@Mapper(uses = { DirectorMapper.class, ActorMapper.class })
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    List<MovieCollection> toMovieCollectionList(List<Movie> movies);

    MovieCollection toMovieCollection(Movie movie);

    MovieDetail toMovieDetail(Movie movie);
}