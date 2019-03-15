package com.acstudent.cache.config;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Wang Siqi
 * @date 2019/3/15
 */
@Component
public class RedisHelper {

    @Resource
    private RedisConfig redisConfig;

    private RedisTemplate masterRedisTemplate;
    private Map<String, RedisTemplate> slaveRedisTemplates;

    @PostConstruct
    public void init() {

    }

    private RedisTemplate buildRedisTemplate(RedisConfig.RedisItem redisItem) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisItem.getHost());
        factory.setPort(redisItem.getPort());
        factory.setDatabase(redisItem.getDatabase());
        //factory.setPoolConfig(redisItem.getPoolConfig());
        return new RedisTemplate();
    }


}
