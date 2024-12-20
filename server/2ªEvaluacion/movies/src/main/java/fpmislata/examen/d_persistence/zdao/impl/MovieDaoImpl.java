package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.d_persistence.zdao.impl.jpa.MovieJpa;
import fpmislata.examen.d_persistence.zdao.impl.mapper.MovieDaoMapper;
import fpmislata.examen.d_persistence.zdao.impl.model.MovieDaoModel;
import fpmislata.examen.d_persistence.zdao.interfaces.MovieDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final MovieJpa movieJpa;

    @Override
    public ListWithCount<Movie> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MovieDaoModel> movieDaoModelPage = movieJpa.findAll(pageable);

        List<Movie> movieList = movieDaoModelPage
                .stream()
                .map(movieDaoModel -> MovieDaoMapper.INSTANCE.toMovie(movieDaoModel))
                .toList();

        return new ListWithCount<>(movieList, movieDaoModelPage.getTotalElements());
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieJpa.findById(id)
                .map(movieDaoModel -> MovieDaoMapper.INSTANCE.toMovie(movieDaoModel));
    }

    @Override
    public Movie save(Movie movie) {
        MovieDaoModel movieDaoModel = movieJpa.save(MovieDaoMapper.INSTANCE.toMovieDaoModel(movie));
        return MovieDaoMapper.INSTANCE.toMovie(movieDaoModel);
    }

    @Override
    public void delete(Integer id) {
        movieJpa.deleteById(id);
    }
}