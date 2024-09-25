package fpmislata.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fpmislata.domain.model.Movie;
import fpmislata.domain.repository.MovieRepository;
import fpmislata.persistence.zdao.MovieDao;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    MovieDao movieDao;

    @Autowired
    public MovieRepositoryImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        return movieDao.findById(id);
    }

    @Override
    public boolean create(Movie movie) {
        return movieDao.create(movie);
    }

    @Override
    public boolean update(Movie movie) {
        return movieDao.update(movie);
    }

    @Override
    public boolean delete(UUID id) {
        return movieDao.delete(id);
    }
}