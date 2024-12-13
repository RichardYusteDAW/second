package fpmislata.bookstore.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import fpmislata.bookstore.a_common.annotation.Dao;
import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.d_persistence.repository.impl.mapper.AuthorRowMapper;
import fpmislata.bookstore.d_persistence.zdao.interfaces.AuthorDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> findAllByBookId(Long bookId) {

        String sql = "SELECT * FROM authors INNER JOIN books_authors ON authors.id = books_authors.author_id WHERE book_id = ?";
        return jdbcTemplate.query(sql, new AuthorRowMapper(), bookId);
    }

    @Override
    public List<Author> getAll(Integer page, Integer size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Author> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Long> save(Author author) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}