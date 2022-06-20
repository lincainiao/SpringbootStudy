package com.lin.controller;

import com.lin.pojo.Girl;
import com.lin.pojo.Institution;
import com.lin.service.GirlService;
import com.lin.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;
import java.util.Collection;

@Controller
public class GirlController {
//    @Autowired
    static GirlService girlService;
    static InstitutionService institutionService;
    static {
        girlService = new GirlService();
        institutionService = new InstitutionService();
    }

    @RequestMapping("/girls")
    public String getGirls(Model model){
        Collection<Girl> girls = girlService.getGirls();
        model.addAttribute("girls",girls);
//        System.out.println(girls.size());
        return "girl/list";
    }

    @GetMapping("/toAdd")
    public String toAddPage(Model model){
        // 在addPage的选择部门下拉框要显示所有部门的名称
        Collection<Institution> institutions = institutionService.getInstitutions();
        model.addAttribute("institutions",institutions);
        return "girl/addPage";
    }

    @PostMapping("/addGirl")
    public String addGirl(Girl girl){
//        System.out.println(girl);
        girlService.add(girl);
        return "redirect:/girls";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model){
//        System.out.println(id);
        Girl girl = girlService.getGirlById(id);
        model.addAttribute("girl",girl);
        model.addAttribute("institutions",institutionService.getInstitutions());
        return "girl/updatePage";
    }

    @RequestMapping("/updateGirl")
    public String updateGirl(Girl girl){
        girlService.add(girl);
        return "redirect:/girls";
    }

    @RequestMapping("/deleteGirl/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(girlService.getGirlById(id));
        girlService.deleteGirlById(id);
        return "redirect:/girls";
    }

}
