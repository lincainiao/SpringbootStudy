package com.lin.service;

import com.lin.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserByName(String name);
}
