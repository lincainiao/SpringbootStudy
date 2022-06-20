package com.lin.service;

import com.lin.pojo.Girl;

import java.util.List;

public interface GirlService {
    List<Girl> getGirls();
    Girl getGirlById(int girlId);
    int updateGirl(Girl girl);
}
