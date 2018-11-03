package com.atguigu.springboot;

import com.atguigu.springboot.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootStarted.class)
public class SpringbootTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public  void test01(){
     redisUtils.set("aa",6666666);
        System.out.println(redisUtils.get("aa"));
      //  System.out.println(userMapper.selectUser());
    }
}
