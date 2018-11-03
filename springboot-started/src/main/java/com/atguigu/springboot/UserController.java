package com.atguigu.springboot;

import com.atguigu.springboot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2018/10/14.
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="myMessage")
    @ResponseBody
    public Object messageList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, HttpServletRequest request) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String,Object>> allMessages =  userMapper.selectUser();
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(allMessages);

        return pageInfo;

    }
}