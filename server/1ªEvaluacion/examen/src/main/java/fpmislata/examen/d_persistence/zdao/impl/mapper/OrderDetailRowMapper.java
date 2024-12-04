package fpmislata.examen.d_persistence.zdao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.examen.c_domain._2service.model.Book;
import fpmislata.examen.c_domain._2service.model.OrderDetail;

public class OrderDetailRowMapper implements RowMapper<OrderDetail> {

    @Override
    @SuppressWarnings("null")
    public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(rs.getInt("id"));
        orderDetail.setQuantity(rs.getInt("quantity"));
        orderDetail.setPrice(rs.getFloat("price"));

        try {
            Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title_es"),
                    rs.getString("title_en"),
                    rs.getString("synopsis_es"),
                    rs.getString("synopsis_en"),
                    rs.getFloat("price"),
                    rs.getString("cover"));
            orderDetail.setBook(book);

        } catch (Exception e) {
            return orderDetail;
        }
        return orderDetail;
    }
}