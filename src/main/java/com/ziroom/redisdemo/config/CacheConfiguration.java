package com.ziroom.redisdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yangjy on 2018/1/24.
 */
@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

    @Value("spring.redis.host")
    private String host;
    @Value("spring.redis.port")
    private Integer port;
    @Value("spring.redis.password")
    private String password;

    public static final String ACCOUNTS_CACHE = "accounts";

    List<String> allCacheNames = Arrays.asList(ACCOUNTS_CACHE);

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(password);
        return factory;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(factory);
        return template;
    }


    /*@Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        if(!allCacheNames.isEmpty()) {
            cacheManager.setCacheNames(allCacheNames);
        }
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }*/


}
