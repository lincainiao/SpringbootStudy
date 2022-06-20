package com.lin.controller;

import com.lin.config.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request){
        // 模拟验证密码
        HttpSession session = request.getSession();
        if (username.equals("000")){
            // 没有该用户
            session.setAttribute("login_msg","no_user");
//            System.out.println(request.getSession().getAttribute("login_msg"));
            return "index";
        }else if (!password.equals("123")){
            // 密码错误
            session.setAttribute("login_msg","wrong_password");
//            System.out.println(request.getSession().getAttribute("login_msg"));
            return "index";
        }else {
            // 登录成功，存入session
            session.setAttribute(Constant.USER_SESSION,username);
//            System.out.println("login success, the login user is "+request.getSession().getAttribute(Constant.USER_SESSION));
            return "redirect:/main.html";
        }
    }

    @RequestMapping("/signout")
    public String signout(HttpServletRequest request){
        request.getSession().removeAttribute(Constant.USER_SESSION);
        return "redirect:/";
    }
}
