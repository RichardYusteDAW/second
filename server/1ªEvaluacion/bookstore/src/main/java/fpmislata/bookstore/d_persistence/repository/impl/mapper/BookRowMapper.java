package fpmislata.bookstore.d_persistence.repository.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.bookstore.c_domain._2service.model.Book;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    @SuppressWarnings("null")
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book = new Book();
        book.setId(rs.getLong("books.id"));
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitleEs(rs.getString("books.title_es"));
        book.setTitleEn(rs.getString("books.title_en"));
        book.setSynopsisEs(rs.getString("books.synopsis_es"));
        book.setSynopsisEn(rs.getString("books.synopsis_en"));
        book.setPrice(rs.getBigDecimal("books.price"));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));

        return book;
    }
}