package com.configutation;

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
@PropertySource(value = {"classpath:redis.properties"})
@ImportResource({"classpath:applicationContext.xml"})
@ComponentScan(basePackages = "com")
@EnableAsync        // <task:annotation-driven/>
@EnableScheduling
@Import({RedisHttpSessionConfig.class, DbInitialization.class})
public class AppConfiguration {

    private static final Log LOG = LogFactory.getLog(AppConfiguration.class);

    /**
     * 读取配置文件
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * TaskExecutor
     *
     * 线程数评估：
     *  AccessService        5
     *  TimeoutHandler       1
     *  DistributeHandler    20
     *  Log                  独立服务
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
