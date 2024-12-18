package fpmislata.examen.d_persistence.zdao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.d_persistence.zdao.impl.mapper.ActorRowMapper;
import fpmislata.examen.d_persistence.zdao.interfaces.ActorDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Actor> findAllByMovieId(Integer movieId) {
        String sql = "SELECT * FROM actor INNER JOIN movie_actor ON actor.id = movie_actor.actor_id WHERE movie_actor.movie_id = ?";

        return jdbcTemplate.query(sql, new ActorRowMapper(), movieId);
    }

    @Override
    public List<Actor> getAll(Integer page, Integer size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Integer> save(Actor t) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Actor> findAllById(Integer[] actorsIds) {

        String sql = "SELECT * FROM actor WHERE id IN (:actorsIds)";

        Map<String, List<Integer>> params = Map.of("actorsIds", Arrays.asList(actorsIds));

        return jdbcTemplate.query(sql, new ActorRowMapper(), params);
    }

    @Override
    public Integer count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
}