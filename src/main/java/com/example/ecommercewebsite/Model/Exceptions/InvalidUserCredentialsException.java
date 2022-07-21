package com.example.ecommercewebsite.Model.Exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Incorrect username or password. Please try again");
    }
}
