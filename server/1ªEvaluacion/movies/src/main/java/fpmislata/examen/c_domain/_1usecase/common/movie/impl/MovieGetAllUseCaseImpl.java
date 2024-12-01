package fpmislata.examen.c_domain._1usecase.common.movie.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieGetAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class MovieGetAllUseCaseImpl implements MovieGetAllUseCase {

    private final MovieService movieService;

    @Override
    public List<Movie> execute(Integer page, Integer size) {
        return movieService.getAll(page, size);
    }
}