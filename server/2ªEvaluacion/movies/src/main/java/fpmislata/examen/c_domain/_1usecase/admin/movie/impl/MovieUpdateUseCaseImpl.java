package fpmislata.examen.c_domain._1usecase.admin.movie.impl;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieUpdateUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class MovieUpdateUseCaseImpl implements MovieUpdateUseCase {

    private final MovieService movieService;

    @Override
    public Integer execute(Movie movie) {
        // Check if movie exists
        movieService.findById(movie.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        return movieService.save(movie)
                .orElseThrow(() -> new RuntimeException("Error updating movie"));
    }
}