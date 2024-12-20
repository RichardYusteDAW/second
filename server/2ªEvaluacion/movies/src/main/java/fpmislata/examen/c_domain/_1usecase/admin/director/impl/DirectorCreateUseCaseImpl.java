package fpmislata.examen.c_domain._1usecase.admin.director.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorCreateUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorCreateUseCaseImpl implements DirectorCreateUseCase {

    private final DirectorService directorService;

    @Override
    public Director execute(Director director) {
        return directorService.create(director);
    }
}