package com.lin.service;

import com.lin.dao.GirlMapper;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class ServiceTest {
//    @Autowired
    static GirlMapper girlMapper;
    static {
        girlMapper = new GirlMapper();
    }

}
