package fpmislata.bookstore.persistence._1mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import fpmislata.bookstore.domain.model.AuthorQuery;

public class AuthorMapper implements RowMapper<AuthorQuery> {

    @Override
    public AuthorQuery mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return new AuthorQuery(
                rs.getInt("authors.id"),
                rs.getString("authors.name"),
                rs.getString("authors.nationality"),
                rs.getString("authors.biography"),
                rs.getInt("authors.birth_year"),
                rs.getInt("authors.death_year"));
    }
}