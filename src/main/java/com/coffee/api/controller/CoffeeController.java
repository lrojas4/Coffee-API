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

    // Gets coffees from orders
    @GetMapping(path = "/orders/{orderId}/coffees/")
    public List<Coffee> getCoffees(@PathVariable Long orderId) {
        return coffeeService.getCoffees(orderId);
    }

    // Gets coffee from order
    @GetMapping(path = "/orders/{orderId}/coffees/{coffeeId}/")
    public Coffee getCoffee(@PathVariable Long orderId, @PathVariable Long coffeeId) {
        return coffeeService.getCoffee(orderId, coffeeId);
    }

    // Updates coffee by coffee id from order by order id
    @PutMapping(path = "/orders/{orderId}/coffees/{coffeeId}")
    public Coffee updateCoffee(@PathVariable Long orderId, @PathVariable Long coffeeId, @RequestBody Coffee coffeeObject) {
        return coffeeService.updateCoffee(orderId, coffeeId, coffeeObject);
    }

    // Deletes coffee by coffee id from order by order id
    @DeleteMapping(path = "/orders/{orderId}/coffees/{coffeeId}" )
    public Coffee deleteCoffee(@PathVariable Long orderId, @PathVariable Long coffeeId) {
        return coffeeService.deleteCoffee(orderId, coffeeId);
    }

}
