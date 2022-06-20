package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync // 开启异步注解的功能
@EnableScheduling // 开启定时功能注解
public class AsynchronousTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousTaskApplication.class, args);
    }

}
