package fpmislata.examen.c_domain._1usecase.common.director.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorGetAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class DirectorFindAllUseCaseImpl implements DirectorGetAllUseCase {

    private final DirectorService directorService;

    @Override
    public List<Director> execute(Integer page, Integer size) {
        return directorService.getAll(page, size);
    }

}