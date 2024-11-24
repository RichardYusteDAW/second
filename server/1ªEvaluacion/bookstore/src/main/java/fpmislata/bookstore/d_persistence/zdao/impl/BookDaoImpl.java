package fpmislata.bookstore.d_persistence.zdao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fpmislata.bookstore.a_common.annotation.Dao;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.d_persistence.repository.impl.mapper.BookRowMapper;
import fpmislata.bookstore.d_persistence.zdao.interfaces.BookDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAll(Integer page, Integer size) {

        String sql = "SELECT * FROM books LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new BookRowMapper(), size, size * page);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        try {
            String sql = "SELECT * FROM books INNER JOIN publishers ON books.publisher_id = publishers.id AND isbn = ?";
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
            return Optional.of(book);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Long> save(Book book) {

        Long id;

        if (book.getId() == null) {
            id = insert(book);
        } else {
            id = update(book);
        }

        return Optional.ofNullable(id);
    }

    private Long insert(Book book) {
        try {
            String sql = "INSERT INTO books(isbn, title_es, title_en, synopsis_es, synopsis_en, price, discount, cover, publisher_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, book.getIsbn());
                ps.setString(2, book.getTitleEs());
                ps.setString(3, book.getTitleEn());
                ps.setString(4, book.getSynopsisEs());
                ps.setString(5, book.getSynopsisEn());
                ps.setBigDecimal(6, book.getPrice());
                ps.setFloat(7, book.getDiscount());
                ps.setString(8, book.getCover());
                ps.setLong(9, book.getPublisher().getId());
                return ps;
            }, keyHolder);

            Number key = keyHolder.getKey();
            return (key != null) ? key.longValue() : null;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private Long update(Book book) {
        try {
            String sql = "UPDATE books SET isbn = ?, title_es = ?, title_en = ?, synopsis_es = ?, synopsis_en = ?, price = ?, discount = ?, cover = ?, publisher_id = ? WHERE id = ?";
            jdbcTemplate.update(sql, book.getIsbn(), book.getTitleEs(), book.getTitleEn(), book.getSynopsisEs(),
                    book.getSynopsisEn(), book.getPrice(), book.getDiscount(), book.getCover(),
                    book.getPublisher().getId(), book.getId());

            return book.getId();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer count() {
        String sql = "SELECT COUNT(*) FROM books";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}