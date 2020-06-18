package com.assignment.webapi.core.order;

import com.assignment.webapi.core.product.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final ProductService productService;

    public OrderService(OrderDao orderDao, ProductService productService) {
        this.orderDao = orderDao;
        this.productService = productService;
    }

    public Order save(Order order) {
        validateOrder(order);
        return this.orderDao.save(getOrder(order));
    }

    private void validateOrder(Order order) {
        if (order.getAmount() == null || order.getAmount() <= 0) {
            throw new RuntimeException("Incorrect value for amount.");
        }
    }

    private Order getOrder(Order order) {
        var newOrder = new Order();  // # Star wars
        newOrder.setId(order.getId());
        newOrder.setAmount(order.getAmount());
        newOrder.setCreatedAt(LocalDateTime.now());

        var product = this.productService.getProduct(order.getProducts().get(0).getId());
        newOrder.setProducts(List.of(product));

        newOrder.setTotalPrice(order.getAmount() * product.getPrice());

        return newOrder;
    }
}
