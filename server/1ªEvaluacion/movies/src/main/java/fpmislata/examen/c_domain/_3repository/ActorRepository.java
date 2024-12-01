package fpmislata.examen.c_domain._3repository;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Actor;

public interface ActorRepository {
    List<Actor> findAllById(Integer[] actorsIds);
}