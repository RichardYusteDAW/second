package fpmislata.examen.c_domain._1usecase.common.movie.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieFindAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MovieFindAllUseCaseImpl implements MovieFindAllUseCase {

    private final MovieService movieService;

    @Override
    public ListWithCount<Movie> execute(Integer page, Integer size) {
        return movieService.findAll(page, size);
    }
}