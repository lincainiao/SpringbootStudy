package com.lin.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.PipedOutputStream;

@Controller
//@RestController
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        // 接收前端参数
        return "helloSpringboot";
    }
}
