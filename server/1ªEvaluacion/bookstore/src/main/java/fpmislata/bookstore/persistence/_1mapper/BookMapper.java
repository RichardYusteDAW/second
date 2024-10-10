package fpmislata.bookstore.persistence._1mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import fpmislata.bookstore.domain.model.Book;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setISBN(rs.getString("books.isbn"));
        book.setTitle(rs.getString("books.title_es"));
        book.setSynopsis(rs.getString("books.synopsis_es"));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        return book;
    }
}