package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.c_domain._3repository.MovieRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.ActorDao;
import fpmislata.examen.d_persistence.zdao.interfaces.MovieDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDao movieDao;
    private final ActorDao actorDao;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        return movieDao.getAll(page, size);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        Optional<Movie> optionalMovie = movieDao.findById(id);

        if (optionalMovie.isEmpty()) {
            return Optional.empty();
        }

        // Set actors
        Movie movie = optionalMovie.get();
        List<Actor> actorList = actorDao.findAllByMovieId(movie.getId());
        movie.setActors(actorList);

        return Optional.of(movie);
    }

    @Override
    public void delete(Integer id) {
        movieDao.delete(id);
    }

    @Override
    public Optional<Integer> save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Integer count() {
        return movieDao.count();
    }
}