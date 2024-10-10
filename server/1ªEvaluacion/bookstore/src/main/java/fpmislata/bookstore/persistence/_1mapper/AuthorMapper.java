package fpmislata.bookstore.persistence._1mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import fpmislata.bookstore.domain.model.Author;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return new Author(
                rs.getInt("authors.id"),
                rs.getString("authors.name"),
                rs.getString("authors.nationality"),
                rs.getString("authors.biography_es"),
                rs.getInt("authors.birth_year"),
                rs.getInt("authors.death_year"));
    }
}