package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.OrderDetailResponse;
import fpmislata.examen.c_domain._2service.model.Order;

@Mapper(uses = BookMapper.class)
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    List<OrderDetailResponse> toOrderDetailResponse(List<Order> orders);
}