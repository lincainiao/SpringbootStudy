package com.lin.mapper;

import com.lin.pojo.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GirlMapper {

    List<Girl> getGirls();
}
