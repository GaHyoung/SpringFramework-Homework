package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class DoorayMessageSenderTest {

    User user = new User(
            "남가형",
            "hi"
    );
    DoorayHook doorayHook;

    @InjectMocks
    private DoorayMessageSender doorayMessageSender;

    @Mock
    private DoorayHookSender doorayHookSender;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void sendMessage() {
        doNothing().when(doorayHookSender).send(any());

        boolean actual = doorayMessageSender.sendMessage(user, user.getMessage());

        verify(doorayHookSender).send(any());
        assertTrue(actual);
    }
}