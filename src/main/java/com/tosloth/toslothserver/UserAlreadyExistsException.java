package com.tosloth.toslothserver;

public class UserAlreadyExistsException extends RuntimeException {
    UserAlreadyExistsException(String nickname) {
        super("User with this (" + nickname + ") nickname already exists");
    }
}
