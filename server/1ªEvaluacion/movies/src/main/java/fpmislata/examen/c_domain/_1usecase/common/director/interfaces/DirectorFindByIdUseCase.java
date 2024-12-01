package fpmislata.examen.c_domain._1usecase.common.director.interfaces;

import fpmislata.examen.c_domain._2service.model.Director;

public interface DirectorFindByIdUseCase {
    Director execute(Integer id);
}