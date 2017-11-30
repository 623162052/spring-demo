package com.redisson;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * redisson config
 *
 * @author shiwx
 */
@Configuration
@PropertySource(value = {"classpath:redis_cluster.properties"})
public class RedissonConfig {

    @Resource
    private Environment environment;

    /**
     * RedissonClient
     * @return
     */
    @Bean(autowire = Autowire.BY_NAME, name = "redissonClient")
    public RedissonClient redissonClient() {
        String redisAddress = environment.getProperty("redisAddress", String.class);
        int slaveIdle = environment.getProperty("slaveIdle", Integer.class, 10);
        int masterIdle = environment.getProperty("masterIdle", Integer.class, 10);
        int soTimeout = environment.getProperty("SoTimeout", Integer.class, 3000);
        int connectionTimeout = environment.getProperty("ConnectionTimeout", Integer.class, 2000);

        if(StringUtils.isBlank(redisAddress)){
            throw new RuntimeException("redisAddress is blank");
        }

        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();


        clusterServersConfig.setConnectTimeout(connectionTimeout);
        clusterServersConfig.setTimeout(soTimeout);
        clusterServersConfig.setSlaveConnectionMinimumIdleSize(slaveIdle);
        clusterServersConfig.setMasterConnectionMinimumIdleSize(masterIdle);

        if(StringUtils.isNotBlank(redisAddress)){
            String[] redisAddressArr = redisAddress.split(",");
            for(String redisAddressItem : redisAddressArr){
                clusterServersConfig.addNodeAddress("redis://" + redisAddressItem);
            }
        }

        return Redisson.create(config);
    }

}
