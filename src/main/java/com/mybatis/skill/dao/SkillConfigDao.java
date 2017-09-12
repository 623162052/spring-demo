package com.mybatis.skill.dao;

import com.mybatis.skill.pojo.SkillConfig;

import java.util.List;

/**
 * Mapper interface
 * Created by shiwx on 2017/5/12.
 */
public interface SkillConfigDao {

    /**
     * 查询单个对象
     * @param skillId
     * @return
     */
    SkillConfig querySkillConfig(int skillId);

    /**
     * 查询列表
     * @return
     */
    List<SkillConfig> querySkillConfigList();

    /**
     * 根据主键删除单个对象
     * @param skillId
     */
    void deleteSkillConfig(int skillId);

    /**
     * 保存单个对象
     * @param skillConfig
     */
    void insertSkillConfig(SkillConfig skillConfig);

}
