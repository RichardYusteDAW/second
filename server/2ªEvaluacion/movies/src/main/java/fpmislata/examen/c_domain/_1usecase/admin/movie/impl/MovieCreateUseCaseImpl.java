package fpmislata.examen.c_domain._1usecase.admin.movie.impl;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieCreateUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class MovieCreateUseCaseImpl implements MovieCreateUseCase {

    private final MovieService movieService;

    @Override
    public Integer execute(Movie movie) {
        return movieService
                .save(movie)
                .orElseThrow(() -> new RuntimeException("Error al guardar la película"));
    }
}