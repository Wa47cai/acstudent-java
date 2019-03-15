package com.acstudent.cache.config;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Wang Siqi
 * @date 2019/3/15
 */
@Data
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    private Map<String, RedisItem> config;

    @Data
    public static class RedisItem {
        private String host;
        private Integer port;
        private String password;
        private Integer database;
        private PoolConfig poolConfig = new PoolConfig();

        @Data
        public static class PoolConfig{
            private long maxWait = 3000L;
            private int maxActive = 8;
        }
    }
}
