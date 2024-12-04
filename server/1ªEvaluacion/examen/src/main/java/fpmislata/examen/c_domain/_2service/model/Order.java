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
    private Integer id;
    private Date order_date;
    private Date delivery_date;
    private String status;
    private Float total;
    private User user;
    private List<OrderDetail> orderDetails;

    // // Calcula el total de la orden
    // public Float getTotal() {
    //     total = 0.0f;
    //     for (OrderDetail orderDetail : orderDetails) {
    //         total += orderDetail.getPrice() * orderDetail.getQuantity();
    //     }
    //     return total;
    // }
}