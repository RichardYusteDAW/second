package fpmislata.examen.c_domain._1usecase.admin.movie.interfaces;

import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieUpdateUseCase {
    Integer execute(Movie movie);
}