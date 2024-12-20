package fpmislata.examen.c_domain._1usecase.admin.director.impl;

import fpmislata.examen.a_common.annotation.UseCase;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorDeleteUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DirectorDeleteUseCaseImpl implements DirectorDeleteUseCase {

    private final DirectorService directorService;

    @Override
    public void execute(Integer id) {
        directorService.delete(id);
    }
}