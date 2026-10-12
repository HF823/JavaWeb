package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 动态条件查询
     */
    List<Clazz> list(String name, LocalDate begin, LocalDate end);

}
