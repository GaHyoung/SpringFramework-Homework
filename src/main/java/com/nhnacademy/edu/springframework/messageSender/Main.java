package com.nhnacademy.edu.springframework.messageSender;


import com.nhnacademy.edu.springframework.messageSender.config.DoorayConfig;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "남가형",
                "test"
        );

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DoorayConfig.class)){
            MessageSendService messageSendService = context.getBean(MessageSendService.class);
            messageSendService.doMessage(user, user.getMessage());
        }

    }
}