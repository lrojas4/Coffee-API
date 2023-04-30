package com.coffee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
// SQL table name
@Table(name = "users")
public class User {

    // Creates a user table with id, userName, email, and password columns
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    // Creates a unique constraint on the email column
    @Column (unique = true)
    private String email;

    // The property may only be written (set) as part of deserialization
    // but will not be read (get) for serialization. Value is not included in
    // serialization
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Adds one-to-one relationship with UserProfile
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    // user can have more than one order
    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Order> orderList;

    // user can have more than one coffee
    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Coffee> coffeeList;

    // Default constructor
    public User() {
    }

    // Constructor
    public User(Long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // gets the user id
    public Long getId() {
        return id;
    }

    // sets the user id
    public void setId(Long id) {
        this.id = id;
    }

    // gets the user's username
    public String getUserName() {
        return userName;
    }

    // sets the user's username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // gets the user's email
    public String getEmail() {
        return email;
    }

    // sets the user's email
    public void setEmail(String email) {
        this.email = email;
    }

    // gets the user's password
    public String getPassword() {
        return password;
    }

    // sets the user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // gets user profile
    public UserProfile getUserProfile() {
        return userProfile;
    }

    // sets user profile
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    // returns string representation
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
