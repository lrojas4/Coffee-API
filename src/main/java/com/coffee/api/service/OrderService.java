package com.coffee.api.service;

import com.coffee.api.exception.InformationExistException;
import com.coffee.api.exception.InformationNotFoundException;
import com.coffee.api.model.Order;
import com.coffee.api.model.User;
import com.coffee.api.repository.OrderRepository;
import com.coffee.api.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }

    // Returns a list of all orders
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // Returns order by id
    public Optional<Order> getOrder(Long orderId) {
        Order order = orderRepository.findByIdAndUserId(orderId,OrderService.getCurrentLoggedInUser().getId());
        if (order == null) {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        } else {
            return Optional.of(order);
        }
    }

    // Creates and order if order doesn't already exista
    public Order createOrder(@RequestBody Order orderObject) {
        Order order= orderRepository.findByUserIdAndName(OrderService.getCurrentLoggedInUser().getId(), orderObject.getName());
        if (order != null) {
            throw new InformationExistException("Order with that name already exists ");
        } else {
            orderObject.setUser(getCurrentLoggedInUser());
            return orderRepository.save(orderObject);
        }
    }

    // Updates an existing order or throws an exception if order does not exist
    public Order updateOrder(Long orderId, Order orderObject) {
        Order order = orderRepository.findByIdAndUserId(orderId, OrderService.getCurrentLoggedInUser().getId());
        if (order != null) {
            if (orderObject.getName().equals(order.getName())) {
                throw new InformationExistException("Order" + order.getName() + " is already exists");
            } else {
                Order updateOrder = orderRepository.findById(orderId).get();
                updateOrder.setName(orderObject.getName());
                updateOrder.setOrderDate(orderObject.getOrderDate());
                updateOrder.setQuantity(orderObject.getQuantity());
                return orderRepository.save(updateOrder);
            }
        } else {
            throw new InformationNotFoundException("Order with id: " + orderId + "not found");
        }
    }

    // Deletes order by order id
    public Optional<Order> deleteOrder(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            orderRepository.deleteById(orderId);
            return order;
        } else {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        }
    }
}
