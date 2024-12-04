package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Order;

public interface OrderDao {
    List<Order> findAll();

    Optional<Order> findById(Integer id);
}