package com.nhnacademy.edu.springframework.messageSender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messageSender.service"})
@PropertySource("classpath:dooray.properties")
public class DoorayConfig {

    @Value("${hookUrl}")
    private String hookUrl;

    @Bean
    public DoorayHookSender doorayHookSender(){
        return new DoorayHookSender(new RestTemplate(), hookUrl);
    }
}
