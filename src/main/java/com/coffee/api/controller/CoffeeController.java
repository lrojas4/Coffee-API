package com.coffee.api.controller;

import com.coffee.api.model.Coffee;
import com.coffee.api.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A combination of @Controller and @ResponseBody annotations.
// Eliminates the need for annotating each method with @ResponseBody
@RestController

// Maps the web requests
@RequestMapping(path = "/api")
public class CoffeeController {

    private CoffeeService coffeeService;

    @Autowired
    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    // Creates a list of coffee per order id
    @PostMapping(path = "/orders/{orderId}/")
    public Coffee createCoffee(@PathVariable Long orderId, @RequestBody Coffee coffeeObject) {
        return coffeeService.createCoffee(orderId, coffeeObject);
    }

    @GetMapping(path = "/orders/{orderId}/coffees/")
    public List<Coffee> getCoffees(@PathVariable Long orderId) {
        return coffeeService.getCoffees(orderId);
    }
}
