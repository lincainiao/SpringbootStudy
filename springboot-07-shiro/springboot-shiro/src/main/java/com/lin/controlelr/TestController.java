package com.lin.controlelr;

import com.lin.service.GirlServiceImpl;
import com.lin.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    GirlServiceImpl girlService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/addUser";
    }
    @RequestMapping("/user/update")
    public String update(){
        return "user/updateUser";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        // 执行登录方法，可能会发生异常
        try {
            currentUser.login(token);
            return "index";
        } catch (UnknownAccountException ue) {
            // 用户名不存在
            model.addAttribute("error","there is no such user!");
            return "login";
        } catch (IncorrectCredentialsException ie){
            // 密码错误
            model.addAttribute("error", "wrong password!");
            return "login";
        }
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorizedPage";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/";
    }
}
