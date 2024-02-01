package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import com.nhnacademy.edu.springframework.messageSender.annotaion.Auditable;
import org.springframework.beans.factory.annotation.Value;

public class DoorayMessageSender implements MessageSender{

    @Value("${name}")
    private String name;

    @Value("${talk}")
    private String talk;

    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    @Auditable
    public boolean sendMessage(User user, String message) {
            doorayHookSender
                .send(DoorayHook.builder()
                .botName(name)
                .text(talk)
                .build());
            return true;
    }
}
