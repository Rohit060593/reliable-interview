package com.reliable.products.exceptions;

public class UserNotFoundException extends RuntimeException{

    private String message;
    public UserNotFoundException(String s) {
        this.message = s;
    }
}
