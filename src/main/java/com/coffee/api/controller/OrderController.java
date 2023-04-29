package com.coffee.api.controller;

import org.springframework.web.bind.annotation.*;

// A combination of @Controller and @ResponseBody annotations.
// Eliminates the need for annotating each method with @ResponseBody
@RestController

// Maps the web requests
@RequestMapping(path = "/api")

public class OrderController {

    // Gets all orders
    // http://localhost:8081/api/orders/
    @GetMapping(path = "/orders/")
    public String getOrders() {
        return "get all orders";
    }

    // Gets order by its id
    // http://localhost:8081/api/orders/1/
    @GetMapping(path = "/orders/{orderId}/")
    public String getOrder(@PathVariable Long orderId) {
        return "creating an order " + orderId;
    }

    // Creates an order
    // http://localhost:8081/api/orders/
    @PostMapping(path = "/orders/")
    public String createOrder(@RequestBody String body) {
        return "creating an order " + body;
    }

    // Updates an order by order id
    // http://localhost:8081/api/orders/1/
    @PutMapping(path = "/orders/{orderId}/")
    public String updateOrder(@PathVariable Long orderId, @RequestBody String body) {
        return "updating the order with order id " + orderId + body;
    }

    // Deletes order by order id
    // http://localhost:8081/api/orders/1/
    @DeleteMapping(path = "/orders/{orderId}/")
    public String deleteOrder(@PathVariable Long orderId) {
        return "deleting the order with the order id " + orderId;
    }

}
