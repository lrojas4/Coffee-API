package com.coffee.api.repository;

import com.coffee.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByName(String name);

    Order findById(String id);
}
