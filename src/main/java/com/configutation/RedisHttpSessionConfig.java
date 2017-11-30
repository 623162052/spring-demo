package com.configutation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * RedisHttpSessionConfig
 * Created by shiwx on 17/2/7.
 */
@PropertySource(value = {"classpath:redis_single.properties"})
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class RedisHttpSessionConfig {

    private static final Log LOG = LogFactory.getLog(RedisHttpSessionConfig.class);

    @Resource
    private Environment environment;

    /**
     * PoolConfig
     *
     * @return
     */
    @Bean
    public JedisPoolConfig poolConfig() {
        int poolSize = environment.getProperty("redis.pool.poolSize", Integer.class);

        JedisPoolConfig jedisPool = new JedisPoolConfig();
        jedisPool.setMaxTotal(poolSize);
        jedisPool.setMinIdle(5);
        int maxIdle = jedisPool.getMinIdle() + 5;
        if (maxIdle > jedisPool.getMaxTotal()) {
            maxIdle = jedisPool.getMaxTotal();
        }
        jedisPool.setMaxIdle(maxIdle);
        jedisPool.setMaxWaitMillis(1000L);
        jedisPool.setTestOnBorrow(false);
        jedisPool.setTestOnReturn(false);
        jedisPool.setTestWhileIdle(true);
        jedisPool.setMinEvictableIdleTimeMillis(600000);
        jedisPool.setTimeBetweenEvictionRunsMillis(30000);
        jedisPool.setNumTestsPerEvictionRun(-1);
        return jedisPool;
    }

    /**
     * ConnectionFactory
     *
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        String redisHost = environment.getProperty("redis.host", String.class);
        int redisPort = environment.getProperty("redis.port", Integer.class);

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisHost);
        connectionFactory.setPort(redisPort);
//        connectionFactory.setDatabase(1);
        connectionFactory.setPoolConfig(poolConfig());
        connectionFactory.afterPropertiesSet();
        return connectionFactory;
    }

    /**
     * RedisTemplate
     *
     * @return
     */
    @Bean
    public RedisTemplate redis() {
        RedisTemplate redis = new RedisTemplate<String, Object>();
        redis.setDefaultSerializer(new StringRedisSerializer());
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new StringRedisSerializer());
        redis.setConnectionFactory(redisConnectionFactory());
        return redis;
    }

//    /**
//     * 日志消息处理
//     */
//    @Bean
//    public MessageListenerAdapter listenerAdapter() {
//        MessageListenerAdapter msgAdapter = new MessageListenerAdapter();
//        msgAdapter.setDelegate(LogQueueDelegateListener.class);
//        msgAdapter.setDefaultListenerMethod("onMessage");
////        msgAdapter.setSerializer(new StringRedisSerializer());
//        return msgAdapter;
//    }
//
//
//    @Bean
//    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter listenerAdapter) {
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(redisConnectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//
//        return container;
//    }

}
