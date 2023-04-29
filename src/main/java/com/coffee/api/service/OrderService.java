package com.coffee.api.service;

import com.coffee.api.exception.InformationExistException;
import com.coffee.api.exception.InformationNotFoundException;
import com.coffee.api.model.Order;
import com.coffee.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    // Creates and order if order doesn't already exista
    public Order createOrder(@RequestBody Order orderObject) {
        Order order= orderRepository.findByName(orderObject.getName());
        if (order != null) {
            throw new InformationExistException("Order with that name already exists ");
        } else {
            return orderRepository.save(orderObject);
        }
    }

    // Updates an existing order or throws an exception if order does not exist
    public Order updateOrder(Long orderId, Order orderObject) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            if (orderObject.getName().equals(order.get().getName())) {
                throw new InformationExistException("Order " + order.get().getName() + " already exists");
            } else {
                Order updateOrder = orderRepository.findById(orderId).get();
                updateOrder.setName(orderObject.getName());
                updateOrder.setOrderDate(orderObject.getOrderDate());
                updateOrder.setQuantity(orderObject.getQuantity());
                return orderRepository.save(updateOrder);
            }
        } else {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        }
    }
}
