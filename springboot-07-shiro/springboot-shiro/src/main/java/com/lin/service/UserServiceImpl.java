package com.lin.service;

import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User getUseByName(String username) {
        return userMapper.getUseByName(username);
    }
}
