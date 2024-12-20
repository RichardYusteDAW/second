package fpmislata.examen.c_domain._1usecase.common.director.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorFindAllUseCaseImpl implements DirectorFindAllUseCase {

    private final DirectorService directorService;

    @Override
    public ListWithCount<Director> execute(Integer page, Integer size) {
        return directorService.findAll(page, size);
    }
}