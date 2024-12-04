package fpmislata.examen.b_presentation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.examen.b_presentation.admin.mapper.OrderMapper;
import fpmislata.examen.b_presentation.admin.model.OrderCollection;
import fpmislata.examen.b_presentation.admin.model.OrderDetailResponse;
import fpmislata.examen.c_domain._1usecase.interfaces.OrderFindAllUseCase;
import fpmislata.examen.c_domain._1usecase.interfaces.OrderFindByIdUseCase;
import fpmislata.examen.c_domain._2service.model.Order;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(OrderController.ENDPOINT)
public class OrderController {

    private final OrderFindAllUseCase orderFindAllUseCase;
    private final OrderFindByIdUseCase orderFindByIdUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/orders";

    @GetMapping()
    public List<OrderCollection> findAll() {
        List<Order> orders = orderFindAllUseCase.execute();
        List<OrderCollection> orderCollections = OrderMapper.INSTANCE.toOrderCollection(orders);

        return orderCollections;
    }

    @GetMapping("/{id}")
    public OrderDetailResponse getMethodName(@PathVariable Integer id) {
        Order order = orderFindByIdUseCase.execute(id);
        OrderDetailResponse orderDetailResponse = OrderMapper.INSTANCE.toOrderDetailResponse(order);
        return orderDetailResponse;
    }
}