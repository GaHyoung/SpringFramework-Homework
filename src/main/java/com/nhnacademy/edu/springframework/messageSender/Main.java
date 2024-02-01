package com.nhnacademy.edu.springframework.messageSender;


import com.nhnacademy.edu.springframework.messageSender.config.DoorayConfig;
import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import com.nhnacademy.edu.springframework.messageSender.service.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@google.com",
                "010-0000-0000"
        );
        String message = "temp message";

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DoorayConfig.class)){
            MessageSendService messageSendService = context.getBean(MessageSendService.class);
            messageSendService.doMessage(user, message);
        }

    }
}