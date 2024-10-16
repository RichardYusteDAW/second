package fpmislata.bookstore.persistence._2impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.domain.model.AuthorCommand;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service._3interfaceRep.BookRepository;
import fpmislata.bookstore.persistence._1mapper.BookMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * from books";
        return jdbcTemplate.query(sql, new BookMapper());
    }

    @Override
    public Optional<Book> findByISBN(String ISBN) {
        try {
            String sql = "SELECT * FROM books WHERE isbn = ?";
            return Optional.of(jdbcTemplate.queryForObject(sql, new BookMapper(), ISBN));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Integer create(Book book) {
        String sql = "INSERT INTO books (isbn, title_es, synopsis_es, price, discount, cover, publisher_id, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, book.getISBN(), book.getTitle(), book.getSynopsis(), book.getPrice(),
                book.getDiscount(), book.getCover(), book.getPublisher().getId(),
                book.getCategory().getId());
    }

    @Override
    public Boolean update(String ISBN, String title, String synopsis, BigDecimal price, Float discount, String cover,
            Publisher publisher, Category category, List<AuthorCommand> authorList, List<Genre> genreList) {
        String sql = "UPDATE books SET title_es = ?, synopsis_es = ?, price = ?, discount = ?, cover = ?, publisher_id = ?, category_id = ? WHERE isbn = ?";

        Integer rows = jdbcTemplate.update(sql, title, synopsis, price, discount, cover, publisher.getId(),
                category.getId(), ISBN);
        return (rows > 0);
    }

    @Override
    public Boolean delete(String ISBN) {
        String sql = "DELETE FROM books WHERE isbn = ?";

        return jdbcTemplate.update(sql, ISBN) > 0;
    }

}
