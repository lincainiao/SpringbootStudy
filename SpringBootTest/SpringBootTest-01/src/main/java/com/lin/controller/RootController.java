package com.lin.controller;

import com.lin.config.Constant;
import com.lin.pojo.Girl;
import com.lin.pojo.User;
import com.lin.service.GirlServiceImpl;
import com.lin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Controller
public class RootController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    GirlServiceImpl girlService;

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        List<Girl> girls = girlService.getGirls();
        return girls.toString();
    }

    @RequestMapping("/file")
    public String download(){
        return "/file";
    }
}
