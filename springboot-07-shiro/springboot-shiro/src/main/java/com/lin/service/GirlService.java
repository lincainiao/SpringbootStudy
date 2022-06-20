package com.lin.service;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface GirlService {
    List<Girl> getGirls();
    Girl getGirlById(int girlId);
    Girl getGirlByName(String girlName);
}
