package com.crud.dao;

import com.mybatis.skill.pojo.SkillConfig;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 基于 SqlSession 的增删改查操作
 * method: selectOne, selectList, insert, delete
 *
 * Created by shiwx on 2017/5/12.
 */
public class SkillConfigDaoSqlSessionTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Test
    public void getSession() throws Exception {
        SqlSession sqlSession = null;
        try {
            assertNotNull(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            assertNotNull(sqlSession);

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 测试查询一条记录
     * @throws Exception
     */
    @Test
    public void selectSkillConfig() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            Map<String, Object > param = new HashMap<>();
            param.put("skillId", 1000111);
            SkillConfig skillConfig = sqlSession.selectOne("com.mybatis.skill.xml.SkillConfigMapper.querySkillConfig", param);
            assertNotNull(skillConfig);
            assertEquals(1000111, skillConfig.getSkillId());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    /**
     * 测试查询一条列表
     * @throws Exception
     */
    @Test
    public void selectSkillConfigList() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<SkillConfig> skillConfig = sqlSession.selectList("com.mybatis.skill.xml.SkillConfigMapper.querySkillConfigList");
            assertNotNull(skillConfig);
            System.out.println("skillConfig: " + skillConfig);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    /**
     * 测试新增一条列表
     * @throws Exception
     */
    @Test
    public void insertSkillConfigList() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            SkillConfig skillConfig = new SkillConfig();
            skillConfig.setSkillId(9999);
            skillConfig.setSkillName("test");
            skillConfig.setIsOverflow("1");
            skillConfig.setQueueMaxSize(12);
            skillConfig.setSkillType(1);
            skillConfig.setOpTime("2017-05-01 11:11:11");
            sqlSession.insert("com.mybatis.skill.xml.SkillConfigMapper.insertSkillConfig", skillConfig);

            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 测试删除一条列表
     * @throws Exception
     */
    @Test
    public void deleteSkillConfig() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            Map<String, Object > param = new HashMap<>();
            param.put("skillId", 9999);
            sqlSession.delete("com.mybatis.skill.xml.SkillConfigMapper.deleteSkillConfig", param);

            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
