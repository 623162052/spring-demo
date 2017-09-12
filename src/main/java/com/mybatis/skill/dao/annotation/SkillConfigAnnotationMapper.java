package com.mybatis.skill.dao.annotation;

import com.mybatis.skill.pojo.SkillConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by shiwx on 2017/5/19.
 */
public interface SkillConfigAnnotationMapper {

     /**
     * 查询单个对象
     * @param skillId
     * @return
     */
    @Select("select * from ir_skill_config where skill_id = #{skillId}")
    @ResultType(SkillConfig.class)
    SkillConfig querySkillConfig(@Param("skillId") int skillId);

    /**
     * 查询列表
     * @return
     */
    @Select("select * from ir_skill_config")
    List<SkillConfig> querySkillConfigList();

    /**
     * 根据主键删除单个对象
     * @param skillId
     */
    @Delete("delete from ir_skill_config where skill_id = #{skillId}")
    void deleteSkillConfig(@Param("skillId") int skillId);

//    /**
//     * 保存单个对象
//     * @param skillConfig
//     */
//    void insertSkillConfig(SkillConfig skillConfig);

}
