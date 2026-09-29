package com.study.springbootdemo.model;

public class User {
    private Long id;
    private String name;
    private Integer age;

    // ✅ Jackson序列化【必须有无参构造】
    public User(){}

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // getter & setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
