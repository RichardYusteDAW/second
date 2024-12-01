package fpmislata.examen.d_persistence.zdao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.examen.c_domain._2service.model.Director;

public class DirectorRowMapper implements RowMapper<Director> {

    @Override
    @SuppressWarnings("null")
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();

        director.setId(rs.getInt("id"));
        director.setName(rs.getString("name"));

        return director;
    }
}