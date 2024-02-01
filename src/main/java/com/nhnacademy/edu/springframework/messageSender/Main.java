package com.nhnacademy.edu.springframework.messageSender;


import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "남가형",
                "test"
        );

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            MessageSendService messageSendService = context.getBean("messageSendService", MessageSendService.class);
            messageSendService.doMessage(user, user.getMessage());
        }

    }
}