package fpmislata.examen.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._3repository.DirectorRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public List<Director> getAll(Integer page, Integer size) {
        return directorRepository.getAll(page, size);
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Integer> create(Director director) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<Integer> update(Director director) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}