package com.redisson;

import com.mybatis.configuration.DbInitialization;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 配置
 * Created by shiwx on 17/2/24.
 */
@Configuration
@PropertySource(value = {"classpath:redis_single.properties"})
@ImportResource({"classpath:applicationContext.xml"})
@ComponentScan(basePackages = "com")
@EnableAsync
@EnableScheduling
@Import({DbInitialization.class, RedissonConfig.class})
public class AppTestConfiguration {

    private static final Log LOG = LogFactory.getLog(AppTestConfiguration.class);

    /**
     * 读取配置文件
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * TaskExecutor
     */
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(30);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(60);
        return executor;
    }

}
