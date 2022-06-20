package com.lin.service;

import com.lin.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUseByName(String username);
}
