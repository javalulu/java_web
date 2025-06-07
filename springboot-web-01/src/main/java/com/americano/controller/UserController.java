package com.americano.controller;

import cn.hutool.core.io.IoUtil;
import com.americano.pojo.User;
import com.americano.service.UserService;
import com.americano.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

//    @RequestMapping("/list")
//    public List<User> list() throws Exception {
//        // 1. 加载并读取user.txt文件，获取用户数据
//        // InputStream in = new FileInputStream(new File("/Users/yuenze/Study_Local/JavaWeb/code/web-ai-project01/springboot-web-01/src/main/resources/user.txt"));
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//        // 2. 解析用户数据，封装为User对象 -> list集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//        }).toList();
//
//        // 3. 返回数据（json)
//        return userList;
//    }
//    属性注入 （最常见）
//    @Qualifier("userServiceImpl")
//    @Autowired
//    private UserService userService;

    @Resource(name = "userServiceImpl") // jakarta包里的，不是spring框架提供的，可直接代替@Autowired和@Qualifier,默认安装名称注入
    private UserService userService;

//    构造器注入 (官方推荐）
//    private final UserService  userService;
//    @Autowired // 如果当前类中只有一个构造函数可省略
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    setter方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        // 调用service, 获取数据
        List<User> userList = userService.findAll();

        // 返回数据（json)
        return userList;
    }
}
