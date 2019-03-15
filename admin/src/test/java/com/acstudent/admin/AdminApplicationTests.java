package com.acstudent.admin;

import com.acstudent.common.dao.UserMapper;
import com.acstudent.common.dao.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Object> serRedisTemplate;

    @Autowired
    UserMapper userMapper;

    @Test
    public void testStringRedisTemplate() {
        //stringRedisTemplate.opsForValue().append("msg", " hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mysetString", "1");
        stringRedisTemplate.opsForList().leftPush("mysetString", "5");
    }

    @Test
    public void testRedisTemplate() {
        User user = userMapper.selectById(1);
        // 保存对象，在默认情况下，使用jdk序列化机制，并将序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("user", user);
        // 1. 将数据以json的方式保存：（1）手动将对象转为json；（2）redisTemplate默认的序列化规则

        serRedisTemplate.opsForValue().set("user", user);
    }

}
