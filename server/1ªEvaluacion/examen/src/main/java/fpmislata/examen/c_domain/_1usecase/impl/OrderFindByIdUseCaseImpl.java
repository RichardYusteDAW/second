package fpmislata.examen.c_domain._1usecase.impl;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.a_common.annotation.DomainTransactional;
import fpmislata.examen.c_domain._1usecase.interfaces.OrderFindByIdUseCase;
import fpmislata.examen.c_domain._2service.interfaces.OrderService;
import fpmislata.examen.c_domain._2service.model.Order;
import lombok.RequiredArgsConstructor;

@DomainService
@DomainTransactional
@RequiredArgsConstructor
public class OrderFindByIdUseCaseImpl implements OrderFindByIdUseCase {

    private final OrderService orderService;

    @Override
    public Order execute(Integer id) {
        return orderService
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}