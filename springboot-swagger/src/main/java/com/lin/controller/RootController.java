package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","index");
        return "/index";
    }
}
