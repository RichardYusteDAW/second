package fpmislata.bookstore.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

        String sql = "SELECT * FROM authors WHERE id = ?";
        Author author = jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), id);

        return Optional.ofNullable(author);
    }

    @Override
    public Optional<Author> findByBookISBN(Integer ISBN) {

        String sql = "SELECT * FROM authors INNER JOIN books_authors ON authors.id = books_authors.author_id WHERE ISBN = ?";
        Author author = jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), ISBN);

        return Optional.ofNullable(author);
    }

    @Override
    public Integer create(Author author) {

        String sql = "INSERT INTO authors (name, nationality, biography_es, biography_en, birthYear, deathYear) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, author.getName(), author.getNationality(), author.getBiographyEs(),
                author.getBiographyEn(), author.getBirthYear(), author.getDeathYear());

        jdbcTemplate.update(sql, author.getId(), author.getName(), author.getNationality(),
                author.getBiographyEs(), author.getBiographyEn(), author.getBirthYear(), author.getDeathYear());

        return author.getId();
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {

        String sql = "UPDATE authors SET name = ?, nationality = ?, biography_en = ?, biography_es = ?, birthYear = ?, deathYear = ?";
        Integer rowsAffected = jdbcTemplate.update(sql, name, nationality, biographyEn, biographyEs, birthYear,
                deathYear, id);

        return rowsAffected > 0;
    }

    @Override
    public Boolean delete(Integer id) {

        String sql = "DELETE FROM authors WHERE id = ?";
        Integer rowsAffected = jdbcTemplate.update(sql, id);

        return rowsAffected > 0;
    }

}
