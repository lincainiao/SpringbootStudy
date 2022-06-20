package com.lin.mapper;

import com.lin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getUsers();
    User getUserByName(String name);
}
