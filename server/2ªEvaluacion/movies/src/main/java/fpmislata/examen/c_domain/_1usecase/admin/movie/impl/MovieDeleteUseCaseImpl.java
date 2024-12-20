package fpmislata.examen.c_domain._1usecase.admin.movie.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieDeleteUseCase;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MovieDeleteUseCaseImpl implements MovieDeleteUseCase {

    private final MovieService movieService;

    @Override
    public void execute(Integer id) {
        // Check if movie exists
        movieService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        movieService.delete(id);
    }
}