package com.coffee.api.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
// SQL table name
@Table(name = "orders")
public class Order {

    // Creates a table with id, order date, quantity,
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate orderDate;

    @Column
    private int quantity;

    // Default constructor
    public Order() {
    }

    // Constructor
    public Order(Long id, LocalDate orderDate, int quantity) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
    }
}
