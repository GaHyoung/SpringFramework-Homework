package com.nhnacademy.edu.springframework.messageSender;

public class User {

    private final String name;
    private final String message;

    public User(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
