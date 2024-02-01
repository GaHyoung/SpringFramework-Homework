package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DoorayMessageSenderTest {
    MessageSender messageSender;
    User user = new User(
            "남가형",
            "hi"
    );

    @Test
    void sendMessage() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        messageSender = new DoorayMessageSender(doorayHookSender);
        boolean result = messageSender.sendMessage(user, user.getMessage());

        Assertions.assertTrue(result);
    }
}