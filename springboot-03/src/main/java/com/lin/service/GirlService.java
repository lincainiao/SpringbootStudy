package com.lin.service;

import com.lin.dao.GirlMapper;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GirlService {
//    @Autowired
    static GirlMapper girlMapper;
    static {
        girlMapper = new GirlMapper();
    }
    public Collection<Girl> getGirls(){
        if (girlMapper == null) {
            System.out.println("GirlService's girlMapper is null");
        }
        return girlMapper.getGirls();
    }

    public void add(Girl girl){
        girlMapper.add(girl);
    }

    public Girl getGirlById(Integer id){
        return girlMapper.getGirlById(id);
    }

    public void deleteGirlById(Integer id){
        girlMapper.deleteGirlById(id);
    }

}
