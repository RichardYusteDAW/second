package fpmislata.examen.b_presentation.admin.model;

import java.sql.Date;
import java.util.List;

public record OrderDetailResponse(
        Integer id,
        Date order_date,
        Date delivery_date,
        String status,
        Float total,
        UserCollection user,
        List<OrderDetailCollection> orderDetails) {
}