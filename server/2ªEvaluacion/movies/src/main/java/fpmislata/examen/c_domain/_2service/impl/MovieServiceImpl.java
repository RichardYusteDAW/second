package fpmislata.examen.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.c_domain._3repository.MovieRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        return movieRepository.getAll(page, size);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        movieRepository.delete(id);
    }

    @Override
    public Optional<Integer> save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Integer count() {
        return movieRepository.count();
    }
}