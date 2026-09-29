package com.itheima.mapper;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
- @Mapper注解：表示是mybatis中的Mapper接口
程序运行时，框架会自动生成接口的实现类对象(代理对象)，并给交Spring的IOC容器管理
 */
@Mapper
public interface UserMapper {
    /**
     * 查询全部
     */
    //- @Select注解：代表的就是select查询，用于书写select查询语句
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据id删除
     */
    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);

    /**
     * 新增用户
     */
    @Insert("insert into user(username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public void insert(User user);

    /**
     * 根据id更新用户信息
     */
    @Update("update user set username = #{username},password = #{password},name = #{name},age = #{age} where id = #{id}")
    public void update(User user);

    /**
     * 根据用户名和密码查询用户信息
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
