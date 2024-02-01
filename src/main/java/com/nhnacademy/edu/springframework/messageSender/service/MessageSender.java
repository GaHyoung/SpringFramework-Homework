package com.nhnacademy.edu.springframework.messageSender.service;

public interface MessageSender {
    void sendMessage(User user, String message);
}
