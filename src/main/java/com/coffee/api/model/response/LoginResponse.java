package com.coffee.api.model.response;

public class LoginResponse {

    private String message;

    // Constructor
    public LoginResponse(String message) {
        this.message = message;
    }

    // gets message
    public String getMessage() {
        return message;
    }

    // sets message
    public void setMessage(String message) {
        this.message = message;
    }
}
