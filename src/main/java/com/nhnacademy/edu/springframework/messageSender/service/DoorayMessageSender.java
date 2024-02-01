package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.annotation.Auditable;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:dooray.properties")
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
