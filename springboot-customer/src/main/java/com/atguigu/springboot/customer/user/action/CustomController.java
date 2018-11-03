package com.atguigu.springboot.customer.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by acer on 2018/10/14.
 */

@Controller
public class CustomController {

    @Autowired
    private RestTemplate  restTemplate;

    @Value("${url}")
    private  String url;

    @GetMapping(value="getSelectAll")
    @ResponseBody
    public  Object  getSelectAll(HttpServletRequest request){
        Object  object=restTemplate.getForObject(url+"/myMessage?currentPage=1&pageSize=5",Object.class);

        return  object;
    }
}
