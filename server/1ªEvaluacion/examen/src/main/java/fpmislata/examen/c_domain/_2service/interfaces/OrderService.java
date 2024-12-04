package fpmislata.examen.c_domain._2service.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Order;

public interface OrderService {
    List<Order> findAll();

    Optional<Order> findById(Integer id);
}