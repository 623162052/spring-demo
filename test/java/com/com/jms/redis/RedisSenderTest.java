package com.com.jms.redis;

import com.configutation.AppConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jms.CommonLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * Created by shiwx on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class RedisSenderTest {

    private static final Log LOG = LogFactory.getLog(RedisSenderTest.class);
    private static Gson gson = new GsonBuilder().create();

    @Autowired
    private RedisTemplate redis;

    /**
     * 发送广播消息
     */
    @Test
    public void testSendLog() throws InterruptedException {
        // topic
        for (int i = 0; i < 5; i++) {
            redis.convertAndSend("log_topic", "Hello from Redis!");
        }
    }


    /**
     * 发送队列消息
     */
    @Test
    public void testSendQueueMsg() throws Exception {
        for(int i=0; i< 10; i++){
            CommonLog commonLog = new CommonLog();
            commonLog.setUniqueId(UUID.randomUUID().toString());
            commonLog.setAgentId("9996000");
            commonLog.setBusiType(111);
            commonLog.setDateTime(new Date().getTime());
            String logStr = gson.toJson(commonLog);
            redis.boundListOps("common_log").leftPush(logStr);

        }
    }

}
