package fpmislata.examen.c_domain._1usecase.admin.director.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorUpdateUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorUpdateUseCaseImpl implements DirectorUpdateUseCase {

    private final DirectorService directorService;

    @Override
    public Director execute(Director director) {
        return directorService.update(director);
    }
}