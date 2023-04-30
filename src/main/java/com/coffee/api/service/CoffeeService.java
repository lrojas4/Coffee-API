package com.coffee.api.service;

import com.coffee.api.exception.InformationNotFoundException;
import com.coffee.api.model.Coffee;
import com.coffee.api.model.Order;
import com.coffee.api.repository.CoffeeRepository;
import com.coffee.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CoffeeService {

    private CoffeeRepository coffeeRepository;

    private OrderRepository orderRepository;


    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Coffee createCoffee (Long orderId, Coffee coffeeObject) {
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            coffeeObject.setOrder(order.get());
            return coffeeRepository.save(coffeeObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        }
    }

}
