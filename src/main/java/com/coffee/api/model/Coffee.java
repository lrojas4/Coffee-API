package com.coffee.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
// SQL table name
@Table(name = "coffees")
public class Coffee {

    // Creates a table with an id, name, description and ingredients list
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String ingredients;

    // Default constructor
    public Coffee() {
    }

    // Constructor
    public Coffee(Long id, String name, String description, String ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    // gets the id number
    public Long getId() {
        return id;
    }

    // sets the id number
    public void setId(Long id) {
        this.id = id;
    }

    // gets the coffee name
    public String getName() {
        return name;
    }

    // sets the coffee name
    public void setName(String name) {
        this.name = name;
    }

    // gets coffee description
    public String getDescription() {
        return description;
    }

    // sets coffee description
    public void setDescription(String description) {
        this.description = description;
    }

    // gets a list of coffee ingredients
    public String getIngredients() {
        return ingredients;
    }

    // sets the list of coffee ingredients
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    // returns string representation
    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
