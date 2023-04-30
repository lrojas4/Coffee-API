package com.coffee.api.model;

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
}
