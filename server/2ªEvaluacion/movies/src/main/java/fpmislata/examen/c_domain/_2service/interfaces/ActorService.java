package fpmislata.examen.c_domain._2service.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorService {
    List<Actor> findAllById(List<Actor> actors);
}