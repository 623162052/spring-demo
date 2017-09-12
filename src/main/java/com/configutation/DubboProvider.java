package com.configutation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Dubbo 启动类
 * Created by shiwx on 2017/6/15.
 */
public class DubboProvider {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

}
