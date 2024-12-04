package fpmislata.examen.c_domain._1usecase.interfaces;

import fpmislata.examen.c_domain._2service.model.Order;

public interface OrderFindByIdUseCase {
    Order execute(Integer id);
}
