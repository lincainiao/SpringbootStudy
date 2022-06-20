package com.lin.service;

import com.lin.pojo.User;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserByName(String name);
}
