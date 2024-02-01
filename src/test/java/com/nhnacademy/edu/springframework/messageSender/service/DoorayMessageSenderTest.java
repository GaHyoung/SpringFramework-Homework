package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class DoorayMessageSenderTest {
    MessageSender messageSender;
    User user = new User(
            "남가형"
    );
    String message = "message";

    @Test
    void sendMessage() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        messageSender = new DoorayMessageSender(doorayHookSender);
        boolean result = messageSender.sendMessage(user, message);

        Assertions.assertTrue(result);
    }
}