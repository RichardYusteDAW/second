package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.OrderCollection;
import fpmislata.examen.b_presentation.admin.model.OrderDetailResponse;
import fpmislata.examen.c_domain._2service.model.Order;

@Mapper(uses = OrderDetailMapper.class)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderCollection> toOrderCollection(List<Order> orders);

    OrderDetailResponse toOrderDetailResponse(Order order);
}