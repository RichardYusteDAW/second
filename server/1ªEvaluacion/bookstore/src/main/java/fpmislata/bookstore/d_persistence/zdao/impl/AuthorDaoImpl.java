package fpmislata.bookstore.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;

import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.d_persistence.repository.impl.mapper.AuthorRowMapper;
import fpmislata.bookstore.d_persistence.zdao.interfaces.AuthorDao;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> findAll() {

        String sql = "SELECT * FROM authors";

        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    @Override
    public Optional<Author> findById(Integer id) {

        try {
            String sql = "SELECT * FROM authors WHERE id = ?";
            Author author = jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), id);

            return Optional.of(author);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Author> findByBookISBN(Integer ISBN) {

        try {
            String sql = "SELECT * FROM authors INNER JOIN books_authors ON authors.id = books_authors.author_id WHERE ISBN = ?";
            Author author = jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), ISBN);

            return Optional.of(author);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Integer create(Author author) {

        try {
            String sql = "INSERT INTO authors (name, nationality, biography_es, biography_en, birth_year, death_year) VALUES (?, ?, ?, ?, ?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, author.getName());
                ps.setString(2, author.getNationality());
                ps.setString(3, author.getBiographyEs());
                ps.setString(4, author.getBiographyEn());
                ps.setInt(5, author.getBirthYear());
                ps.setInt(6, author.getDeathYear());
                return ps;
            }, keyHolder);

            Number key = keyHolder.getKey();
            return (key != null) ? key.intValue() : null;

        } catch (Exception e) {
            return null;
        }
    };

    @Override
    public Boolean update(Author author) {

        try {
            String sql = "UPDATE authors SET name = ?, nationality = ?, biography_en = ?, biography_es = ?, birth_year = ?, death_year = ? WHERE id = ?";
            Integer rowsAffected = jdbcTemplate.update(sql, author.getName(), author.getNationality(),
                    author.getBiographyEn(), author.getBiographyEs(), author.getBirthYear(), author.getDeathYear(),
                    author.getId());

            return rowsAffected > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Integer id) {

        try {
            String sql = "DELETE FROM authors WHERE id = ?";
            Integer rowsAffected = jdbcTemplate.update(sql, id);

            return rowsAffected > 0;

        } catch (Exception e) {
            return false;
        }
    }
}
