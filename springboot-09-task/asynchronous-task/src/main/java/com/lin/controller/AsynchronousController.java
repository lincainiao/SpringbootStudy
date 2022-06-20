package com.lin.controller;

import com.lin.service.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynchronousController {

    @Autowired
    AsynchronousService asynchronousService;

    @RequestMapping("/hello")
    public String hello(){
        asynchronousService.hello(); // 线程延迟3秒
        return "Done!";
    }
}
