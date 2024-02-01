package com.nhnacademy.edu.springframework.messageSender;


import com.nhnacademy.edu.springframework.messageSender.domain.User;
import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "가형"
        );
        String message = "message";

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            MessageSendService messageSendService = context.getBean("messageSendService", MessageSendService.class);
            messageSendService.doMessage(user, message);
        }

    }
}