package com.lin.controller;

import com.lin.config.Constant;
import com.lin.pojo.User;
import com.lin.service.GirlServiceImpl;
import com.lin.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Authenticator;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    GirlServiceImpl girlService;

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){
        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        // 将前端获取的用户名和密码封装
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            currentUser.login(token);
            return "main";
        } catch (UnknownAccountException unknownAccountException) {
            System.out.println("未知用户");
            return "index";
        } catch (IncorrectCredentialsException incorrectCredentialsException){
            System.out.println("用户名密码错误");
            return "index";
        }
    }
    @RequestMapping("/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/index";
    }
    @RequestMapping("/unauthorizedPage")
    public String unauthorizedPage(){
        return "/unauthorizedPage";
    }
}

