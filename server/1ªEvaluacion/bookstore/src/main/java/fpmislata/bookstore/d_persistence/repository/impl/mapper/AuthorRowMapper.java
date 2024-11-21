package fpmislata.bookstore.d_persistence.repository.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.bookstore.c_domain._2service.model.Author;

public class AuthorRowmapper implements RowMapper<Author> {

    @Override
    @SuppressWarnings("null")
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        // Create a new Book
        Author author = new Author();

        // Set the book's attributes
        author.setId(rs.getLong("id"));
        author.setName(rs.getString("name"));
        author.setNationality(rs.getString("nationality"));
        author.setBiographyEs(rs.getString("biography_es"));
        author.setBiographyEn(rs.getString("biography_en"));
        author.setBirthYear(rs.getInt("birth_year"));
        author.setDeathYear(rs.getInt("death_year"));

        return author;
    }
}
