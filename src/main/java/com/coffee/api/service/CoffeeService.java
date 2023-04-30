package com.coffee.api.service;

import com.coffee.api.exception.InformationNotFoundException;
import com.coffee.api.model.Coffee;
import com.coffee.api.model.Order;
import com.coffee.api.repository.CoffeeRepository;
import com.coffee.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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

    // gets coffees from orders
    public List<Coffee> getCoffees(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get().getCoffeeList();
        } else {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        }
    }

    // Gets coffee based on coffee id and order id
    public Coffee getCoffee (@PathVariable Long orderId, @PathVariable Long coffeeId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            Optional<Coffee> coffee = coffeeRepository.findByOrderId(
                    orderId).stream().filter(r -> r.getId().equals(coffeeId)).findFirst();
            if(coffee.isPresent()){
                return coffee.get();
            } else {
                throw new InformationNotFoundException("Coffee with id  " + coffeeId + " not found");
            }
        } else {
            throw new InformationNotFoundException("Order with id " + orderId + " not found");
        }
    }

    public Coffee updateCoffee(@PathVariable Long orderId, @PathVariable Long coffeeId, @PathVariable Coffee coffeeObject) {
        try {
            Coffee coffee = (coffeeRepository.findByOrderId(
                    orderId).stream().filter(p -> p.getId().equals(coffeeId)).findFirst()).get();
            coffee.setName(coffeeObject.getName());
            coffee.setSize(coffeeObject.getSize());
            coffee.setIngredients(coffeeObject.getIngredients());
            return coffeeRepository.save(coffee);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Coffee or order not found");
        }

    }







}
