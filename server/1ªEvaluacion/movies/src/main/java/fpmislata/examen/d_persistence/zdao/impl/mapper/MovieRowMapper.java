package fpmislata.examen.d_persistence.zdao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.Movie;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    @SuppressWarnings("null")
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Movie movie = new Movie();

        movie.setId(rs.getInt("id"));
        movie.setTitleEn(rs.getString("titleEn"));
        movie.setTitleEs(rs.getString("titleEs"));
        movie.setDescriptionEn(rs.getString("descriptionEn"));
        movie.setDescriptionEs(rs.getString("descriptionEs"));

        try {
            Director director = new Director(rs.getInt("director.id"), rs.getString("director.name"));
            movie.setDirector(director);
        } catch (Exception e) {
            return movie;
        }

        return movie;
    }
}