package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication：标注该类是一个springboot应用
@SpringBootApplication
public class Springboot01HellospringbootApplication {

    public static void main(String[] args) {
        // 将springboot应用启动
        SpringApplication.run(Springboot01HellospringbootApplication.class, args);
    }
}
