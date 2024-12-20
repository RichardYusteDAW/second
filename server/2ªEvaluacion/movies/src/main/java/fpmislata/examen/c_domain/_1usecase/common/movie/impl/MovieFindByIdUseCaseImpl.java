package fpmislata.examen.c_domain._1usecase.common.movie.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieFindByIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MovieFindByIdUseCaseImpl implements MovieFindByIdUseCase {

    private final MovieService movieService;

    @Override
    public Movie execute(Integer id) {
        return movieService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }
}