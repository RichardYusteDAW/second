package fpmislata.examen.c_domain._2service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fpmislata.examen.c_domain._2service.interfaces.MovieService;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.c_domain._3repository.MovieRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public ListWithCount<Movie> findAll(Integer page, Integer size) {
        return movieRepository.findAll(page, size);
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
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}