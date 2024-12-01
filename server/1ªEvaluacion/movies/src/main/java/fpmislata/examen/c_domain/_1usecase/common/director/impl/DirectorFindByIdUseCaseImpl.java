package fpmislata.examen.c_domain._1usecase.common.director.impl;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindByIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class DirectorFindByIdUseCaseImpl implements DirectorFindByIdUseCase {

    private final DirectorService directorService;

    @Override
    public Director execute(Integer id) {
        return directorService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));
    }

}