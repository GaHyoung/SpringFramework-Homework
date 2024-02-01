package com.nhnacademy.edu.springframework.messageSender.service;

import org.springframework.stereotype.Service;

@Service
public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
