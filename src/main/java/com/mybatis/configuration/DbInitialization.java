package com.mybatis.configuration;

import com.mybatis.skill.dao.SkillConfigDao;
import com.mybatis.skill.dao.annotation.SkillConfigAnnotationMapper;
import com.mybatis.skill.pojo.SkillConfig;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by shiwx on 2017/5/20.
 */
@PropertySource(value = {"classpath:db.properties"})
public class DbInitialization {

    @Resource
    private org.springframework.core.env.Environment environment;

    @Bean
    public DataSource dataSource() {
        String driverClassName = environment.getProperty("driverClassName", String.class);
        String url = environment.getProperty("aiir.url", String.class);
        String username = environment.getProperty("aiir.username", String.class);
        String password = environment.getProperty("aiir.password", String.class);

        Properties properties = new Properties();
        properties.setProperty("driver", driverClassName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        return pooledDataSourceFactory.getDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        DataSource dataSource = dataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        // 自动映射
        configuration.setMapUnderscoreToCamelCase(true);

        // 注册 TypeAlias
        TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();
        typeAliasRegistry.registerAlias(SkillConfig.class);

        // 添加 Mapper
        configuration.addMapper(SkillConfigAnnotationMapper.class);
        configuration.addMapper(SkillConfigDao.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }


}
