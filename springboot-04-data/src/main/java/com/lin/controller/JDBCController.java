package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库库的所有信息
    @RequestMapping("/girls")
    public List<Map<String, Object>> userList(){
        String sql = "select * from girls";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @RequestMapping("/add")
    public String add(){
        String sql = "insert into girls values (10086,'ytm',18,'student')";
        int update = jdbcTemplate.update(sql);
        return "add Done!";
    }

    @RequestMapping("delete")
    public String delete(){
        String sql = "delete from girls where girlId = 10086";
        int update = jdbcTemplate.update(sql);
        return "delete Done!";
    }

    // http://localhost:8080/update/'maid'
    @RequestMapping("update/{job}")
    public String update(@PathVariable("job") String job){
        String sql = "update girls set job = ?, girlId = ? where job = "+job;
        // 封装参数
        Object[] params = new Object[2];
        params[0] = "student";
        params[1] = 6;
        jdbcTemplate.update(sql,params);
        return "update Done!";
    }
}
