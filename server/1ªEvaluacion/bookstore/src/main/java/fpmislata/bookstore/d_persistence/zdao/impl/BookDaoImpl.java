package fpmislata.bookstore.d_persistence.zdao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.d_persistence.repository.impl.mapper.BookRowMapper;
import fpmislata.bookstore.d_persistence.zdao.interfaces.BookDao;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAll(Integer page, Integer size) {

        String sql = "SELECT * FROM books LIMIT ?, ?";
        return jdbcTemplate.query(sql, new BookRowMapper(), page, size);
    }

    @Override
    public Integer count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        try {
            String sql = "SELECT * FROM book WHERE isbn = ?";
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
    public Optional<Long> save(Book book) {

        Long id = (book.getId() == null) ? insert(book) : update(book);
        this.deleteAuthors(book.getId());
        this.insertAuthors(book.getId(), book.getAuthors());

        return Optional.ofNullable(id);
    }

    private Long update(Book book) {

        try {
            String sql = "UPDATE books SET isbn = ?, title_es = ?, title_en = ?, synopsis_es = ?, synopsis_en = ?, price = ?, discount = ?, cover = ?, publisher_id = ? WHERE id = ?";
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
                ps.setLong(10, book.getId());
                return ps;
            }, keyHolder);

            Number key = keyHolder.getKey();
            return (key != null) ? key.longValue() : null;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

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

    private void deleteAuthors(Long bookId) {
        try {
            String sql = "DELETE FROM books_authors WHERE book_id = ?";
            jdbcTemplate.update(sql, bookId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertAuthors(Long bookId, List<Author> authors) {
        try {
            String sql = "DELETE FROM books_authors WHERE book_id = ?";
            jdbcTemplate.update(sql, bookId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}