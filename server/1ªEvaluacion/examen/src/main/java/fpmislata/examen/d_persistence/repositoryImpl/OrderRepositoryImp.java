package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Order;
import fpmislata.examen.c_domain._2service.model.OrderDetail;
import fpmislata.examen.c_domain._3repository.OrderRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.OrderDao;
import fpmislata.examen.d_persistence.zdao.interfaces.OrderDetailDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImp implements OrderRepository {

    private final OrderDao orderDao;
    private final OrderDetailDao orderDetailDao;

    public List<Order> findAll() {
        List<Order> orders = orderDao.findAll();
        return orders;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        Optional<Order> optionalOrder = orderDao.findById(id);

        if (optionalOrder.isEmpty()) {
            return Optional.empty();
        }

        // Set OrderDetails to Order
        Order order = optionalOrder.get();
        List<OrderDetail> orderDetails = orderDetailDao.findAllByOrderId(order.getId());
        order.setOrderDetails(orderDetails);

        return Optional.of(order);
    }
}