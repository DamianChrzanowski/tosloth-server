package com.tosloth.toslothserver;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String id) {
        super("Could not find employee " + id);
    }
}
