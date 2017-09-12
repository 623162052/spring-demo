package com.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by shiwx on 2017/4/20.
 */
@Component("logQueueDelegateListener")
public class LogQueueDelegateListener  {

    private static final Log LOG = LogFactory.getLog(LogQueueDelegateListener.class);

    @Autowired
    private RedisTemplate redis;

    @Autowired
    private RedisQueue<String> redisQueue;

//    @Override
    public void handleMessage(String message) {
//        String data = RedisQueue.getInstance().rightPop("log");
        String data = redisQueue.rightPop("aaa");
        LOG.error("[onMessage]: " + data);
    }

}
