package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {

    /**
     * 条件分页查询
     * @param name
     * @param begin
     * @param end
     * @param page
     * @param pageSize
     */
    PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    /**
     * 新增班级
     * @param clazz
     */
    void save(Clazz clazz);

    /**
     * 根据id查询班级
     */
    Clazz getInfo(Integer id);

    /**
     * 修改班级信息
     */
    void update(Clazz clazz);

    /**
     * 根据id删除班级
     */
    void deleteById(Integer id);

    /**
     * 查询全部班级
     * @return
     */
    List<Clazz> findAll();
}
