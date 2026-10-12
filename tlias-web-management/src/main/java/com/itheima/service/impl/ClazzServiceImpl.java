package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize){
        PageHelper.startPage(page,pageSize);

        List<Clazz> dataList = clazzMapper.list( name, begin, end);
        Page<Clazz> p =(Page<Clazz>) dataList;

        return new PageResult(p.getTotal(), p.getResult());
    }

}
