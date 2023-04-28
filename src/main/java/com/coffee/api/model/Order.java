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

    // gets order id
    public Long getId() {
        return id;
    }

    // sets order id
    public void setId(Long id) {
        this.id = id;
    }

    // gets order date
    public LocalDate getOrderDate() {
        return orderDate;
    }

    // sets order date
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    // gets order quantity
    public int getQuantity() {
        return quantity;
    }

    // sets order quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                '}';
    }
}
