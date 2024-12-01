package fpmislata.examen.d_persistence.zdao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.Movie;
import fpmislata.examen.d_persistence.zdao.impl.mapper.MovieRowMapper;
import fpmislata.examen.d_persistence.zdao.interfaces.MovieDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        String sql = "SELECT * FROM movie LIMIT ? OFFSET ?";

        return jdbcTemplate.query(sql, new MovieRowMapper(), size, size * page);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        String sql = "SELECT * FROM movie INNER JOIN director ON movie.director_id = director.id WHERE movie.id = ?";
        try {
            Movie movie = jdbcTemplate.queryForObject(sql, new MovieRowMapper(), id);
            return Optional.of(movie);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM movie WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Integer> save(Movie movie) {
        Integer movieId;

        if (movie.getId() == null) {
            movieId = insert(movie);
        } else {
            movieId = update(movie);
        }

        deleteActors(movieId);
        insertActors(movieId, movie.getActors());

        return Optional.ofNullable(movieId);
    }

    @SuppressWarnings("null")
    private Integer insert(Movie movie) {
        try {

            String sql = "INSERT INTO movie (titleEn, titleEs, descriptionEn, descriptionEs, director_id) VALUES (?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, movie.getTitleEn());
                ps.setString(2, movie.getTitleEs());
                ps.setString(3, movie.getDescriptionEn());
                ps.setString(4, movie.getDescriptionEs());
                ps.setInt(5, movie.getDirector().getId());
                return ps;
            }, keyHolder);

            return keyHolder.getKey().intValue();

        } catch (Exception e) {
            return null;
        }
    }

    private Integer update(Movie movie) {
        try {
            String sql = "UPDATE movie SET titleEn = ?, titleEs = ?, descriptionEn = ?, descriptionEs = ?, director_id = ? WHERE id = ?";

            jdbcTemplate.update(sql, movie.getTitleEn(), movie.getTitleEs(), movie.getDescriptionEn(),
                    movie.getDescriptionEs(), movie.getDirector().getId(), movie.getId());

            return movie.getId();

        } catch (Exception e) {
            return null;
        }
    }

    private void deleteActors(Integer movieId) {
        String sql = "DELETE FROM movie_actor WHERE movie_id = ?";

        jdbcTemplate.update(sql, movieId);
    }

    private void insertActors(Integer movieId, List<Actor> actors) {
        String sql = "INSERT INTO movie_actor (movie_id, actor_id) VALUES (?, ?)";

        actors.forEach(a -> jdbcTemplate.update(sql, movieId, a.getId()));
    }

    @Override
    public Integer count() {
        String sql = "SELECT COUNT(*) FROM movie";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}