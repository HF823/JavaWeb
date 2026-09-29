package com.study.springbootdemo.controller;

import com.study.springbootdemo.model.Result;
import com.study.springbootdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // ========== 1. 返回JSON对象 ==========
    @GetMapping("/getUserJson")
    public Result<User> getUserJson(){
        User user = new User(1L,"张三",20);
        return Result.success(user);
    }
    /*
    访问：GET http://localhost:8080/getUserJson
    返回JSON：
    {
        "code":200,
        "msg":"success",
        "data":{"id":1,"name":"张三","age":20}
    }
    */

    // ========== 2. GET简单参数接收 ==========
    // url: /getByName?name=李四
    @GetMapping("/getByName")
    public Result<String> getByName(String name){
        return Result.success("收到name：" + name);
    }

    // ========== 3. @RequestParam：参数名映射、设置是否必填 ==========
    // url: /get?username=王五
    @GetMapping("/get")
    public Result<String> get(
            @RequestParam(value = "username", required = true) String name
    ){
        return Result.success("name = " + name);
    }
    // required=true 不传参数直接报错；required=false 非必传

    // ========== 4. GET请求，实体类接收参数 ==========
    // url: /getUserByObj?id=2&name=李四&age=22
    @GetMapping("/getUserByObj")
    public Result<User> getUserByObj(User user){
        return Result.success(user);
    }
    // 要求：url参数名 和 User属性名完全一致

    // ========== 5. POST接收JSON（最常用）@RequestBody ==========
    @PostMapping("/addUser")
    public Result<String> addUser(@RequestBody User user){
        System.out.println(user.getName());
        return Result.success("新增成功，id=" + user.getId());
    }
    /*
    请求：POST http://localhost:8080/addUser
    请求头：Content-Type: application/json
    请求体Body:
    {
        "id":3,
        "name":"赵六",
        "age":25
    }
    */
}
