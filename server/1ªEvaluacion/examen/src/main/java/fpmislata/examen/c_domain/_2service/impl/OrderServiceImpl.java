package fpmislata.examen.c_domain._2service.impl;

import java.util.List;
import java.util.Optional;

import fpmislata.examen.a_common.annotation.DomainService;
import fpmislata.examen.c_domain._2service.interfaces.OrderService;
import fpmislata.examen.c_domain._2service.model.Order;
import fpmislata.examen.c_domain._3repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }
}
