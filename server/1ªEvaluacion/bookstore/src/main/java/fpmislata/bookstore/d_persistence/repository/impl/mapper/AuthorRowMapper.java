package fpmislata.bookstore.d_persistence.repository.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import fpmislata.bookstore.c_domain.model.Author;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    @SuppressWarnings("null")
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author(
                rs.getInt("authors.id"),
                rs.getString("authors.name"),
                rs.getString("authors.nationality"),
                rs.getString("authors.biography_es"),
                rs.getString("authors.biography_en"),
                rs.getInt("authors.birth_year"),
                rs.getInt("authors.death_year"));
    }
}