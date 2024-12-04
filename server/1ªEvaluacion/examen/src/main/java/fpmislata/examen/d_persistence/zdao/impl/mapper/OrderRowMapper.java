package fpmislata.examen.d_persistence.zdao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.examen.c_domain._2service.model.Order;
import fpmislata.examen.c_domain._2service.model.User;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    @SuppressWarnings("null")
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setOrder_date(rs.getDate("order_date"));
        order.setDelivery_date(rs.getDate("delivery_date"));
        order.setTotal(rs.getFloat("total"));

        Integer statusInt = rs.getInt("status");
        String status;
        switch (statusInt) {
            case 0:
                status = "Pending";
                break;
            case 1:
                status = "Actuated";
                break;
            case 2:
                status = "Cancelled";
                break;
            case 3:
                status = "In transit";
                break;
            case 4:
                status = "Delivered";
                break;
            default:
                status = "Unknown";
                break;
        }
        order.setStatus(status);

        try {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    rs.getString("address"),
                    rs.getBoolean("admin"));

            order.setUser(user);
        } catch (Exception e) {
            return order;
        }

        return order;
    }
}