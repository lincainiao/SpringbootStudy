package com.lin.service;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.RuntimeUtil;

import java.util.List;

@Service
@Repository
public class GirlServiceImpl implements GirlService{

    @Autowired
    GirlMapper girlMapper;
    @Override
    public List<Girl> getGirls() {
        List<Girl> girls = girlMapper.getGirls();
        return girls;
    }

    @Override
    public Girl getGirlById(int girlId) {
        return girlMapper.getGirlById(girlId);
    }

    @Override
    public Girl getGirlByName(String girlName) {
        return girlMapper.getGirlByName(girlName);
    }
}
