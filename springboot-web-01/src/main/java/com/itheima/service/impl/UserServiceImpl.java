package com.itheima.service.impl;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
//@Component
public class UserServiceImpl implements UserService{
    @Autowired//应用程序运行时，会自动查找该类型的bean对象，并赋值给该成员变量
    private UserDao userDao ;

    @Override
    public List<User> findAll(){
        //调用dao,获取数据
        List<String> lines = userDao.findAll();
        //解析用户信息，封装User对象-> list集合
        List<User> userList =lines.stream().map(line ->{
            String[] parts = line.split(",");
            Integer id =Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id,username,password,name,age,updateTime);

        }).toList();

        return userList;
    }


}
