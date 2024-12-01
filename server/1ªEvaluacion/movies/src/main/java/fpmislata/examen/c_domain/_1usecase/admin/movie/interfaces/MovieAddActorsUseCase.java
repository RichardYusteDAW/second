package fpmislata.examen.c_domain._1usecase.admin.movie.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface MovieAddActorsUseCase {
    void execute(Integer idMovie, List<Actor> actors);
}