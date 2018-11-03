package com.atguigu.springboot.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by acer on 2018/10/14.
 */

@Configuration
public class RedisConfig {

    /*@Bean
    public RedisConnectionFactory  redisConnectionFactory(){
        JedisConnectionFactory  redisConnectionFactory=new JedisConnectionFactory();
        redisConnectionFactory.setPort(6379);
        redisConnectionFactory.setHostName("127.0.0.1");
        return   redisConnectionFactory;
    }*/

  /*  @Bean
    public RedisTemplate<String,Object>   redisTemplate(RedisConnectionFactory  redisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<String,Object>();
        template.setConnectionFactory(redisConnectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;

    }*/
}
