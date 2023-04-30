package com.coffee.api.controller;

import com.coffee.api.model.Order;
import com.coffee.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Returns order by id
    @GetMapping(path= "/orders/{orderId}/")
    public Optional<Order> getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    // Creates an order
    @PostMapping(path = "/orders/")
    public Order createOrder(@RequestBody Order orderObject) {
        return orderService.createOrder(orderObject);
    }

    // Updates an existing order
    @PutMapping(path = "/orders/{orderId}/")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order orderObject) {
        return orderService.updateOrder(orderId, orderObject);
    }

    // Deletes order by order id
    @DeleteMapping(path= "/orders/{orderId}/")
    public Optional<Order> deleteOrder(@PathVariable Long orderId) {
        return orderService.deleteOrder(orderId);
    }
}
