package com.nhnacademy.edu.springframework.messageSender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender{

    @Value("${hookUrl}")
    private String hookUrl;
    @Value("${name}")
    private String name;

    @Value("${talk}")
    private String talk;

    @Override
    public void sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), hookUrl)
                .send(DoorayHook.builder()
                        .botName(name)
                        .text(talk)
                        .build());
    }
}
