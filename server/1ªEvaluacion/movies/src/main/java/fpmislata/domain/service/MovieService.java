package fpmislata.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import fpmislata.domain.model.Movie;

public interface MovieService {

    public List<Movie> findAll();

    public Optional<Movie> findById(UUID id);

    public boolean create(String title, Integer year);

    public boolean update(UUID id, String title, Integer year);

    public boolean delete(UUID id);
}