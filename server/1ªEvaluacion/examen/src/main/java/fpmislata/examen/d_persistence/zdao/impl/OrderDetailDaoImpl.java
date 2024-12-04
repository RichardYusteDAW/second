package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.OrderDetail;
import fpmislata.examen.d_persistence.zdao.impl.mapper.OrderDetailRowMapper;
import fpmislata.examen.d_persistence.zdao.interfaces.OrderDetailDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class OrderDetailDaoImpl implements OrderDetailDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderDetail> findAllByOrderId(Integer orderId) {

        String sql = "SELECT * FROM `orders_details` INNER JOIN `books` ON `orders_details`.`book_id` = `books`.`id` WHERE `orders_details`.`order_id` = ?";

        return jdbcTemplate.query(sql, new OrderDetailRowMapper(), orderId);
    }
}