package com.lin.mapper;

import com.lin.pojo.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// 该注解表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface GirlMapper {
    List<Girl> getGirls();

    Girl getGirlById(int id);

    int addGirl(Map<String, Object> map);
    int deleteGirlById(Map<String, Object> map);
    int updateGirlById(int id);
}
