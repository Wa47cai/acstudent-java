package com.acstudent.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Wang Siqi
 * @date 2018/11/1
 */
public class StringCacheManager {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


}
