package com.lin.service;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class GirlServiceImpl implements GirlService{
    @Autowired
    GirlMapper girlMapper;
    @Override
    public List<Girl> getGirls() {
       return girlMapper.getGirls();
    }

    @Override
    public Girl getGirlById(int girlId) {
        return girlMapper.getGirlById(girlId);
    }

    @Override
    public int updateGirl(Girl girl) {
        return girlMapper.updateGirl(girl);
    }
}
