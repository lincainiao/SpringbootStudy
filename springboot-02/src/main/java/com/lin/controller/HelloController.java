package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// springboot
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello springboot";
    }
}
