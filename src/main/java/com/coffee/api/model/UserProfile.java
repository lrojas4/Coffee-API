package com.coffee.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class UserProfile {

    // Creates a table with columns id, firstName, lastName, profileDescription
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String profileDescription;

    // adds one-to-one relationship with user
    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;

    // Default constructor
    public UserProfile() {
    }

    // Constructor
    public UserProfile(Long id, String firstName, String lastName, String profileDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileDescription = profileDescription;
    }

    // gets user profile id
    public Long getId() {
        return id;
    }

    // sets user profile id
    public void setId(Long id) {
        this.id = id;
    }

    // gets user profile first name
    public String getFirstName() {
        return firstName;
    }

    // sets user profile first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // gets user profile last name
    public String getLastName() {
        return lastName;
    }

    // sets user profile last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // gets user profile description
    public String getProfileDescription() {
        return profileDescription;
    }

    // sets user profile description
    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    // gets user
    public User getUser() {
        return user;
    }

    // sets user
    public void setUser(User user) {
        this.user = user;
    }

    // returns string representation
    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                '}';
    }
}
