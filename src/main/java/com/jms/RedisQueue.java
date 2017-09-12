package com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by shiwx on 2017/4/24.
 */
@Component
public class RedisQueue<T> {

    @Autowired
    private RedisTemplate redis;

    public void leftPush(String key, T value){
        BoundListOperations<String, T> listOperations = redis.boundListOps(key);
        listOperations.leftPush(value);
    }

    public T rightPop(String key){
        BoundListOperations<String, T> listOperations = redis.boundListOps(key);
        return listOperations.rightPop();
    }

}
