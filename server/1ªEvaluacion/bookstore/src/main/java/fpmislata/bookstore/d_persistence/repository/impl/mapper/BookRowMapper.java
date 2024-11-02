package fpmislata.bookstore.d_persistence.repository.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.c_domain._2service.model.Publisher;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    @SuppressWarnings("null")
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        // Create a new Book
        Book book = new Book();

        // Set the book's attributes
        book.setId(rs.getLong("id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitleEs(rs.getString("title_es"));
        book.setTitleEn(rs.getString("title_en"));
        book.setSynopsisEs(rs.getString("synopsis_es"));
        book.setSynopsisEn(rs.getString("synopsis_en"));
        book.setPrice(rs.getBigDecimal("price"));
        book.setDiscount(rs.getFloat("discount"));
        book.setCover(rs.getString("cover"));

        // Set the book's publisher
        Long publisherId = rs.getLong("publisher_id");
        String publisherName = rs.getString("name");
        String publisherSlug = rs.getString("slug");
        book.setPublisher(new Publisher(publisherId, publisherName, publisherSlug));

        return book;
    }
}