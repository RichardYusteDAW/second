package fpmislata.domain.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpmislata.domain.model.Movie;
import fpmislata.domain.repository.MovieRepository;
import fpmislata.domain.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        return movieRepository.findById(id);
    }

    @Override
    public boolean create(String title, Integer year) {
        Movie movie = new Movie(UUID.randomUUID(), title, year);
        try {
            return movieRepository.create(movie);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(UUID id, String title, Integer year) {
        Optional<Movie> movieOptional = findById(id);

        // Check if the movie exists
        if (!movieOptional.isPresent())
            return false;

        Movie movie = movieOptional.get();
        movie.setTitle(title);
        movie.setYear(year);
        return movieRepository.update(movie);
    }

    @Override
    public boolean delete(UUID id) {
        // Check if the movie exists
        if (!findById(id).isPresent())
            return false;

        return movieRepository.delete(id);
    }
}