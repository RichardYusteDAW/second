package fpmislata.examen.c_domain._1usecase.common.movie.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Movie;

public interface MovieGetAllUseCase {
    List<Movie> execute(Integer page, Integer size);
}
