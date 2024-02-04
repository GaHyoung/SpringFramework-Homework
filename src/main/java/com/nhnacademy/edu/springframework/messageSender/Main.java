package com.nhnacademy.edu.springframework.messageSender;


import com.nhnacademy.edu.springframework.messageSender.config.DoorayConfig;
import com.nhnacademy.edu.springframework.messageSender.domain.User;
import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "가형"
        );
        String message = "message";

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DoorayConfig.class)){
            MessageSendService messageSendService = context.getBean(MessageSendService.class);
            messageSendService.doMessage(user, message);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}