package com.nhnacademy.edu.springframework.messageSender.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messageSender.aspect"})
@EnableAspectJAutoProxy
public class DoorayConfig {
}
