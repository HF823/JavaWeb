package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
    @Select("select id, name, create_time createTime, update_time updateTime from dept")
    public List<Dept> findAll();

    /**
     * 根据id删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 保存部门
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     */
    @Select("select id,name,create_time createTime,update_time updateTime from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
