package com.nhnacademy.edu.springframework.messageSender.domain;

public class User {

    private final String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
