package com.example.mproject.domain;

import java.util.Date;

/**
 * @ClassName: People
 * @Description:
 * @Author: pzl
 * @CreateDate: 2020/11/13 14:42
 * @Version: 1.0
 */
public class People {
    private String name;
    private int age;
    private Date birthday;

    public People() {
    }

    public People(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
