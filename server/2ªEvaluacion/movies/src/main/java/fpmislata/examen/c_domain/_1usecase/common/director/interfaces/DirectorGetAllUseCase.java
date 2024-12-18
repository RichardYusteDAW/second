package fpmislata.examen.c_domain._1usecase.common.director.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Director;

public interface DirectorGetAllUseCase {
    List<Director> execute(Integer page, Integer size);
}
