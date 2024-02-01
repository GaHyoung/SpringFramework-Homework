package com.nhnacademy.edu.springframework.messageSender.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messageSender.aspect.ExecutionTimeAspect;
import com.nhnacademy.edu.springframework.messageSender.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messageSender.service.MessageSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:dooray.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DoorayConfig {

    @Value("${hookUrl}")
    private String hookUrl;

    @Bean
    public DoorayHookSender doorayHookSender(){

        return new DoorayHookSender(new RestTemplate(), hookUrl);
    }

    @Bean
    public DoorayMessageSender doorayMessageSender(){
        return new DoorayMessageSender(doorayHookSender());
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(doorayMessageSender());
    }

    @Bean
    public ExecutionTimeAspect executionTimeAspect(){
        return new ExecutionTimeAspect();
    }
}
