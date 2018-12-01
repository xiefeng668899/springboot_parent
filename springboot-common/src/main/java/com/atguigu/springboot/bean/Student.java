package com.atguigu.springboot.bean;


import lombok.Data;

/**
 * Created by acer on 2018/11/25.
 */

@Data
public class Student {

    private String name;

    public String method(User student) {

        return "123456";
    }

    public static void main(String[] args) {
        System.out.println("我在这里加了一行   会不会起冲突");
        System.out.println("大家好才是真的好");
    }

}

