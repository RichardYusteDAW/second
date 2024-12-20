package fpmislata.examen.c_domain._1usecase.common.director.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindByMovieIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorFindByMovieIdUseCaseImpl implements DirectorFindByMovieIdUseCase {

    private final DirectorService directorService;

    @Override
    public Director execute(Integer movieId) {

        return directorService.findByMovieId(movieId)
                .orElseThrow(() -> new RuntimeException("Director not found"));
    }
}