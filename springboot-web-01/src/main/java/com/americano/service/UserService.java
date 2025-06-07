package com.americano.service;

import com.americano.pojo.User;

import java.util.List;

public interface UserService {
    // 查询所有用户信息
    public List<User> findAll();
}
