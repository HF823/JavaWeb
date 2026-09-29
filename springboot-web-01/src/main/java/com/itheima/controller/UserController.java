package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息Controller
 */
@RestController
public class UserController {
    //方式一：属性注入
    //@Qualifier("userServiceImpl")  基于Autowired和Qualifier标明加载哪个bean
    //@Autowired
    @Resource(name = "userServiceImpl")//Resource指定加载的bean
    private UserService userService;

    //方式二：构造器注入
    //private final UserService userService;
    //@Autowired
    //public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    //方式三：setter方法注入
    //private  UserService userService;
    //@Autowired
    //public void setUserService(UserService userService) {
    //    this.userService = userService;
    //}

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        //使用service，获取数据
        List<User> userList = userService.findAll();

        //返回数据,Json格式
        return userList;
    }
}
