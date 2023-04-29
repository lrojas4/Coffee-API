package com.coffee.api.service;


import com.coffee.api.model.Order;
import com.coffee.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setCategoryRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Returns a list of all orders
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // Returns order by id
    public Order getOrder(@PathVariable Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
