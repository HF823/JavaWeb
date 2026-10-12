package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;

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
}
