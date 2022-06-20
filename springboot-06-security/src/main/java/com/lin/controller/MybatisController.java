package com.lin.controller;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import com.lin.pojo.User;
import com.lin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    GirlMapper girlMapper;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/test")
    public String test(){
        User zhizhi = userService.getUserByName("zhizhi");
        return zhizhi.toString();
    }
}
