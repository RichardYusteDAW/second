package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.d_persistence.zdao.impl.mapper.DirectorRowMapper;
import fpmislata.examen.d_persistence.zdao.interfaces.DirectorDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class DirectorDaoImpl implements DirectorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Director> getAll(Integer page, Integer size) {
        String sql = "SELECT * FROM director LIMIT ? OFFSET ?";

        return jdbcTemplate.query(sql, new DirectorRowMapper(), size, size * page);
    }

    @Override
    public Optional<Director> findById(Integer id) {
        String sql = "SELECT * FROM director WHERE id = ?";

        return Optional.of(jdbcTemplate.queryForObject(sql, new DirectorRowMapper(), id));
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM director WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Integer> save(Director t) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Integer count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
}