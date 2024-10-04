package fpmislata.bookstore.persistence.repositoryImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service.interfaceRep.BookRepository;
import fpmislata.bookstore.persistence.mapper.BookMapper;
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
    public Book findByISBN(String ISBN) {
        try {
            String sql = "SELECT * FROM books WHERE isbn = ?";
            return jdbcTemplate.queryForObject(sql, new BookMapper(), ISBN);

        } catch (Exception e) {
            return null;
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
            Publisher publisher, Category category, List<Author> authorList, List<Genre> genreList) {
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
