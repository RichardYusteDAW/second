package fpmislata.examen.c_domain._2service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fpmislata.examen.c_domain._2service.interfaces.DirectorService;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._3repository.DirectorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public ListWithCount<Director> findAll(Integer page, Integer size) {
        return directorRepository.findAll(page, size);
    }

    @Override
    public Optional<Director> findByMovieId(Integer movieId) {
        return directorRepository.findByMovieId(movieId);
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorRepository.findById(id);
    }

    @Override
    public Director create(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director update(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public void delete(Integer id) {
        directorRepository.delete(id);
    }
}