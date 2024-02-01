package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhnacademy.edu.springframework.messageSender.domain.User;

public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
