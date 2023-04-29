package com.coffee.api.controller;

import com.coffee.api.model.Order;
import com.coffee.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A combination of @Controller and @ResponseBody annotations.
// Eliminates the need for annotating each method with @ResponseBody
@RestController

// Maps the web requests
@RequestMapping(path = "/api")

public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    // Returns a list of all orders
    @GetMapping(path = "/orders/")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

}
