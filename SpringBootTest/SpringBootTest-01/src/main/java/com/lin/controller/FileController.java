package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileController {
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request){
        System.out.println(file.getSize());
        return "file";
    }
}
