package com.lin.controller;

import com.lin.pojo.User;
import com.lin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/allUsers")
    public String allUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("msg",users.toString());
        model.addAttribute("users",users);
        return "/user/user_list";
    }
}
