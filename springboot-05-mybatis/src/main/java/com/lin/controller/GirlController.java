package com.lin.controller;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GirlController {

    @Autowired
    private GirlMapper girlMapper;

    @RequestMapping("/girls")
    public String getGirls(){
        List<Girl> girls = girlMapper.getGirls();
        for (Girl girl : girls) {
            System.out.println(girl);
        }
        return girls.toString();
    }

}
