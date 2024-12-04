package fpmislata.examen.c_domain._1usecase.impl;

import java.util.List;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.a_common.annotation.DomainTransactional;
import fpmislata.examen.c_domain._1usecase.interfaces.OrderFindAllUseCase;
import fpmislata.examen.c_domain._2service.interfaces.OrderService;
import fpmislata.examen.c_domain._2service.model.Order;
import lombok.RequiredArgsConstructor;

@DomainService
@DomainTransactional
@RequiredArgsConstructor
public class OrderFindAllUseCaseImpl implements OrderFindAllUseCase {

    private final OrderService orderService;

    @Override
    public List<Order> execute() {
        return orderService.findAll();
    }
}