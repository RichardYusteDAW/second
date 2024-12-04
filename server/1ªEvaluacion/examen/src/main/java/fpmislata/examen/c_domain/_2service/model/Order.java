package fpmislata.examen.c_domain._2service.model;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    Integer id;
    Date order_date;
    Date delivery_date;
    String status;
    Float total;
    User user;
    List<OrderDetail> orderDetails;

    // // Calcula el total de la orden
    // public Float getTotal() {
    //     total = 0.0f;
    //     for (OrderDetail orderDetail : orderDetails) {
    //         total += orderDetail.getPrice() * orderDetail.getQuantity();
    //     }
    //     return total;
    // }
}