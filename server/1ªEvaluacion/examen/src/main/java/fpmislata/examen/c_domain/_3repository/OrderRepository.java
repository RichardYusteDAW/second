package fpmislata.examen.c_domain._3repository;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Order;

public interface OrderRepository {
    List<Order> findAll();

    Optional<Order> findById(Integer id);
}