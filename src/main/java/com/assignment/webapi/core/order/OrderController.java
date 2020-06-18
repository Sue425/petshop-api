package com.assignment.webapi.core.order;

import org.springframework.web.bind.annotation.*;

import static com.assignment.webapi.common.Routing.API_PREFIX;
import static com.assignment.webapi.common.Routing.ORDER;

@RestController
@RequestMapping(API_PREFIX + ORDER)
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setId(null);
        return this.orderService.save(order);
    }
}
