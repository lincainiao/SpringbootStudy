package com.lin.controller;

import com.lin.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello swagger";
    }

    // 只要该接口返回值中存在实体类，它就会被扫描到swagger
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @PostMapping("/test")
    @ApiOperation("Test方法")  // 写在方法的注释
    public String test(@ApiParam("用户名") String username){
        return "test"+username;
    }
}
