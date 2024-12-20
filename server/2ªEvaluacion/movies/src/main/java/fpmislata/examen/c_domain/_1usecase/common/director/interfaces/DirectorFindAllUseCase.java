package fpmislata.examen.c_domain._1usecase.common.director.interfaces;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface DirectorFindAllUseCase {
    ListWithCount<Director> execute(Integer page, Integer size);
}
