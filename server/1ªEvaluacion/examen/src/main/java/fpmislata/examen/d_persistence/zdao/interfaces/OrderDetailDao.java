package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.List;

import fpmislata.examen.c_domain._2service.model.OrderDetail;

public interface OrderDetailDao {
    List<OrderDetail> findAllByOrderId(Integer orderId);
}