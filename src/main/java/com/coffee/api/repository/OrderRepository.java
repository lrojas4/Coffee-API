package com.coffee.api.repository;

import com.coffee.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByName(String name);

    Order findById(String id);

    // get all categories that belong to logged-in user
    List<Order> findByUserId(Long userId);

    // get category by id and user id
    Order findByIdAndUserId(Long orderId, Long userId);

    // We are trying to find category with name and user id
    Order findByUserIdAndName(Long userId, String orderName);
}
