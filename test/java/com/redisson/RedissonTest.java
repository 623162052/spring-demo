package com.redisson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfiguration.class})
public class RedissonTest extends TestCase {

    private static final Log LOGGER = LogFactory.getLog(RedissonTest.class);

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 测试连通性
     *
     * @throws Exception
     */
    @Test
    public void testConnect() throws Exception {
        RMap<String, Object> testMap = redissonClient.getMap("testMap");
        testMap.put("key", "value");
    }

}
