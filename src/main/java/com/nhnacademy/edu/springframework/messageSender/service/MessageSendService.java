package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhnacademy.edu.springframework.messageSender.User;
import org.springframework.stereotype.Service;

public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
