package fpmislata.examen.c_domain._1usecase.common.movie.impl;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieCountUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class MovieCountUseCaseImpl implements MovieCountUseCase {

    private final MovieService movieService;

    @Override
    public Integer execute() {
        return movieService.count();
    }
}