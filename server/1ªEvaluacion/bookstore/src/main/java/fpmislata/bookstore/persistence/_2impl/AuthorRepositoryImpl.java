package fpmislata.bookstore.persistence._2impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.service._3interfaceRep.AuthorRepository;
import fpmislata.bookstore.persistence._1mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> findAll() {
        String sql = "SELECT * from authors";
        return jdbcTemplate.query(sql, new AuthorMapper());
    }

    @Override
    public Optional<Author> findById(Integer id) {
        try {
            String sql = "SELECT * FROM authors WHERE id = ?";
            return Optional.of(jdbcTemplate.queryForObject(sql, new AuthorMapper(), id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Integer create(Author author) {
        String sql = "INSERT INTO authors ( name, nationality, biography_es, birth_year, death_year) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, author.getName(), author.getNationality(),
                author.getBiography(), author.getBirthYear(), author.getDeathYear());
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography, Integer birthYear,
            Integer deathYear) {
        String sql = "UPDATE authors SET name = ?, nationality = ?, biography_es = ?, birth_year = ?, death_year = ? WHERE id = ?";
        return jdbcTemplate.update(sql, name, nationality, biography, birthYear, deathYear, id) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}