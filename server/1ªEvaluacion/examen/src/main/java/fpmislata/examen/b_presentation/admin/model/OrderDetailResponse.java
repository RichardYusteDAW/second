package fpmislata.examen.b_presentation.admin.model;

import java.sql.Date;
import java.util.List;

import fpmislata.examen.c_domain._2service.model.OrderDetail;

public record OrderDetailResponse(Integer id,
                Date order_date,
                Date delivery_date,
                String status,
                Float total,
                UserCollection user,
                List<OrderDetail> orderDetails) {
}