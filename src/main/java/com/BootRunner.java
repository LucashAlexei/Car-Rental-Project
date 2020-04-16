package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.controllers", "com.logic"})
public class BootRunner {

    public static void main(String[] args) {
        SpringApplication.run(BootRunner.class, args);
    }

}
