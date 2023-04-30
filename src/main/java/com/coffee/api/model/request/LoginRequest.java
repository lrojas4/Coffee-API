package com.coffee.api.model.request;

public class LoginRequest {

    private String email;

    private String password;


    // gets email
    public String getEmail() {
        return email;
    }

    // sets email
    public void setEmail(String email) {
        this.email = email;
    }

    // gets password
    public String getPassword() {
        return password;
    }

    // sets password
    public void setPassword(String password) {
        this.password = password;
    }
}
