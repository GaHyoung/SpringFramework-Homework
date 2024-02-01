package com.nhnacademy.edu.springframework.messageSender.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messageSender"})
@PropertySource("classpath:dooray.properties")
@EnableAspectJAutoProxy
public class DoorayConfig {

    @Value("${hookUrl}")
    private String hookUrl;

    @Bean
    public DoorayHookSender doorayHookSender(){
        return new DoorayHookSender(new RestTemplate(), hookUrl);
    }
}
