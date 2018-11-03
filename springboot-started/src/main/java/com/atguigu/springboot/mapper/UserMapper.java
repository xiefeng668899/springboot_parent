package com.atguigu.springboot.mapper;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2018/10/14.
 */
public interface UserMapper {

    public List<Map<String,Object>> selectUser();
}
