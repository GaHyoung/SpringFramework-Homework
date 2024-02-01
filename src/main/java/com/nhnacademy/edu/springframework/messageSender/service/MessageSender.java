package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhnacademy.edu.springframework.messageSender.domain.User;

public interface MessageSender {
    boolean sendMessage(User user, String message);
}
