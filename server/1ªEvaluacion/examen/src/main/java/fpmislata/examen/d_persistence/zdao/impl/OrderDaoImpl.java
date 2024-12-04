package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Order;
import fpmislata.examen.d_persistence.zdao.impl.mapper.OrderRowMapper;
import fpmislata.examen.d_persistence.zdao.interfaces.OrderDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Order> findAll() {
        String sql = "SELECT * FROM `orders`";

        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public Optional<Order> findById(Integer id) {
        String sql = "SELECT * FROM `orders` INNER JOIN `users` ON `orders`.`user_id` = `users`.`id` WHERE `orders`.`id` = ?";

        try {
            Order order = jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
            return Optional.of(order);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}