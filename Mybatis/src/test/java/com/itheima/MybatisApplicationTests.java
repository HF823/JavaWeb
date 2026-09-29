package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
/*
    @Test
    public void testDeleteById(){
        userMapper.deleteById(5);
        System.out.println("已删除该id信息");
    }

 */
    /*
@Test
public void testInsert(){
    User user = new User();
    user.setUsername("admin");
    user.setPassword("123456");
    user.setName("管理员");
    user.setAge(30);
    userMapper.insert(user);
    System.out.println("已添加一个新用户");
}
     */
    /*
@Test
public void testUpdate(){
    User user = new User();
    user.setId(1);
    user.setUsername("daqiao");
    user.setPassword("1234567");
    user.setName("大乔");
    user.setAge(30);
    userMapper.update(user);
    System.out.println("已修改用户信息");
}
     */
@Test
public void testFindByUsernameAndPassword(){
    User user = userMapper.findByUsernameAndPassword("admin", "123456");
    System.out.println(user);
}

}
