package fpmislata.examen.c_domain._1usecase.common.movie.interfaces;

import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieFindByIdUseCase {
    Movie execute(Integer id);
}