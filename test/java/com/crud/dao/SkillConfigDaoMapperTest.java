package com.crud.dao;

import com.configutation.AppConfiguration;
import com.mybatis.skill.dao.SkillConfigDao;
import com.mybatis.skill.pojo.SkillConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 基于 Mapper 增删改查操作
 *
 * Created by shiwx on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class SkillConfigDaoMapperTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    /**
     * 测试查询一条记录
     * @throws Exception
     */
    @Test
    public void selectSkillConfig() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            SkillConfigDao mapper = sqlSession.getMapper(SkillConfigDao.class);
            SkillConfig skillConfig = mapper.querySkillConfig(1000111);
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
            SkillConfigDao mapper = sqlSession.getMapper(SkillConfigDao.class);
            List<SkillConfig> skillConfig = mapper.querySkillConfigList();
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
            SkillConfigDao mapper = sqlSession.getMapper(SkillConfigDao.class);

            SkillConfig skillConfig = new SkillConfig();
            skillConfig.setSkillId(9999);
            skillConfig.setSkillName("test");
            skillConfig.setIsOverflow("1");
            skillConfig.setQueueMaxSize(12);
            skillConfig.setSkillType(1);
            skillConfig.setOpTime("2017-05-01 11:11:11");
            mapper.insertSkillConfig(skillConfig);

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
    public void deleteSkillConfigList() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            SkillConfigDao mapper = sqlSession.getMapper(SkillConfigDao.class);

            mapper.deleteSkillConfig(9999);

            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
