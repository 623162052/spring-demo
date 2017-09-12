package com.crud.dao;

import com.configutation.AppConfiguration;
import com.mybatis.skill.dao.annotation.SkillConfigAnnotationMapper;
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
 * Created by shiwx on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class SkillConfigAnnotationMapperTest {

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
            SkillConfigAnnotationMapper mapper = sqlSession.getMapper(SkillConfigAnnotationMapper.class);
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
            SkillConfigAnnotationMapper mapper = sqlSession.getMapper(SkillConfigAnnotationMapper.class);
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
     * 测试删除一条列表
     * @throws Exception
     */
    @Test
    public void deleteSkillConfigList() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            SkillConfigAnnotationMapper mapper = sqlSession.getMapper(SkillConfigAnnotationMapper.class);
            mapper.deleteSkillConfig(9999);

            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
