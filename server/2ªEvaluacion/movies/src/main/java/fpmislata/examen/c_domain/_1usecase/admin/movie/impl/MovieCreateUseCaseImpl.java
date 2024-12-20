package fpmislata.examen.c_domain._1usecase.admin.movie.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieCreateUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MovieCreateUseCaseImpl implements MovieCreateUseCase {

    private final MovieService movieService;

    @Override
    public Movie execute(Movie movie) {
        return movieService.save(movie);
    }
}