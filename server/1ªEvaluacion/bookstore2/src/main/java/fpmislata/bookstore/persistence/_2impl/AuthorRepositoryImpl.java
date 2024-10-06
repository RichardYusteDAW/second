package fpmislata.bookstore.persistence._2impl;

import java.util.List;

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
    public Author findById(Integer id) {
        try {
            String sql = "SELECT * FROM authors WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new AuthorMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer create(Author author) {
        String sql = "INSERT INTO authors (id, name, nationality, biography_es, birth_year, death_year)";
        return jdbcTemplate.update(sql, author.getId(), author.getName(), author.getNationality(),
                author.getBiography(), author.getBirthYear(), author.getDeathYear());
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography, int birthYear, int deathYear) {
        String sql = "UPDATE authors SET name = ?, nationality = ?, biography = ?, birthYear = ?, deathYear = ?";
        return jdbcTemplate.update(sql, name, nationality, biography, birthYear, deathYear) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}