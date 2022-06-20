package com.lin.controller;

import com.lin.pojo.Girl;
import com.lin.service.GirlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.SocketTimeoutException;
import java.util.List;

@Controller
public class GirlController {
    @Autowired
    GirlServiceImpl girlService;

    @RequestMapping("/allGirls")
    public String allGirls(Model model){
        List<Girl> girls = girlService.getGirls();
        model.addAttribute("girls",girls);
        return "/girl/girl_list";
    }

    @RequestMapping("/toGirlEditPage/{girlId}")
    public String girlEdit(Model model, @PathVariable("girlId") int girlId){
        Girl girl = girlService.getGirlById(girlId);
        model.addAttribute(girl);
        return "/girl/girl_edit";
    }

    @RequestMapping("/editGirl")
    public String editGirl(Girl girl){
        System.out.println(girl.toString());
        int i = girlService.updateGirl(girl);
        return "redirect:/allGirls";
    }
}
