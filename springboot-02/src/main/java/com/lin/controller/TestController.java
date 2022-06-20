package com.lin.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @RequestMapping("/test")
//    @ResponseBody
    public String test(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("msg","this is a test");
//        model.addAttribute("msg","this is a test");
        System.out.println("test");
        return "test";
    }

    @RequestMapping("/todo")
    public String todo(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        Object msg = session.getAttribute("msg");
        System.out.println("todo ");
        return "redirect:/test";
    }
}
