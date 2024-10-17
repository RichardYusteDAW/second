package fpmislata.bookstore.persistence._2impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.common.locale.LanguageUtils;
import fpmislata.bookstore.domain.model.AuthorCommand;
import fpmislata.bookstore.domain.model.AuthorQuery;
import fpmislata.bookstore.domain.service._3interfaceRep.AuthorRepository;
import fpmislata.bookstore.persistence._1mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<AuthorQuery> findAll() {
        String language = LanguageUtils.getCurrentLanguage();
        String sql = "SELECT id, name, nationality, biography_" + language
                + "  AS biography, birth_year, death_year FROM authors";
        return jdbcTemplate.query(sql, new AuthorMapper());
    }

    @Override
    public Optional<AuthorQuery> findById(Integer id) {

        try {
            String language = LanguageUtils.getCurrentLanguage();
            String sql = "SELECT id, name, nationality, biography_" + language
                    + "  AS biography, birth_year, death_year FROM authors WHERE id = ?";

            return Optional.of(jdbcTemplate.queryForObject(sql, new AuthorMapper(), id));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Integer create(AuthorCommand author) {
        String sql = "INSERT INTO authors ( name, nationality, biography_en, biography_es, birth_year, death_year) VALUES (?, ?, ?, ?, ?, ?)";
        Integer rows = jdbcTemplate.update(sql, author.getName(), author.getNationality(), author.getBiography_en(),
                author.getBiography_es(), author.getBirthYear(), author.getDeathYear());

        return rows;
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography_en, String biography_es,
            Integer birthYear, Integer deathYear) {
        String sql = "UPDATE authors SET name = ?, nationality = ?, biography_en = ?, biography_es = ?, birth_year = ?, death_year = ? WHERE id = ?";
        Integer rows = jdbcTemplate.update(sql, name, nationality, biography_en, biography_es, birthYear, deathYear,
                id);

        return rows > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        Integer rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }
}