package fpmislata.persistence.zdao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import fpmislata.domain.model.Movie;

public interface MovieDao {

    public List<Movie> findAll();

    public Optional<Movie> findById(UUID id);

    public boolean create(Movie movie);

    public boolean update(Movie movie);

    public boolean delete(UUID id);
}
