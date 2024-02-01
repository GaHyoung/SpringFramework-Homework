package com.nhnacademy.edu.springframework.messageSender.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messageSender.service"})
@PropertySource("classpath:dooray.properties")
public class DoorayConfig {
}
