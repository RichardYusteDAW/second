package fpmislata.examen.c_domain._1usecase.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.Order;

public interface OrderFindAllUseCase {
    List<Order> execute();
}