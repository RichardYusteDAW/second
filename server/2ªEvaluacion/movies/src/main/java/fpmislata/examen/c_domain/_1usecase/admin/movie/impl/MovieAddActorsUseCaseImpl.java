package fpmislata.examen.c_domain._1usecase.admin.movie.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieAddActorsUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MovieAddActorsUseCaseImpl implements MovieAddActorsUseCase {

    private final MovieService movieService;

    @Override
    public void execute(Integer idMovie, List<Actor> actors) {

        Movie movie = movieService
                .findById(idMovie)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        actors.forEach(actor -> movie.addActor(actor));

        movieService.save(movie);
    }
}