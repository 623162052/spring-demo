//package com.mybatis.skill.pojo;
//
//import org.apache.ibatis.jdbc.SqlBuilder;
//
///**
// * Created by shiwx on 2017/5/20.
// */
//public class SkillConfigSqlProvider extends SqlBuilder {
//
//
//    public String select() {
//        BEGIN();
//        SELECT("*");
//        FROM("ir_skill_config");
//        return SQL();
//    }
//
//
//    public String delete() {
//        BEGIN();
//        DELETE_FROM("ir_skill_config");
//        WHERE("username = #{username}");
//        return SQL();
//    }
//
//    public String insert() {
//        BEGIN();
//        INSERT_INTO("ir_skill_config");
//        VALUES("SKILL_ID", "#{skillId}");
//        VALUES("SKILL_NAME", "#{skillName}");
//        VALUES("SKILL_DESC", "#{skillDesc}");
//        VALUES("PRIORITY_ORDER", "#{priorityOrder}");
//        VALUES("QUEUE_MAX_SIZE", "#{queueMaxSize}");
//
//        VALUES("QUEUE_MAX_SIZE", "#{queueMaxSize}");
//        VALUES("QUEUE_TIMEOUT", "#{queueTimeout}");
//        VALUES("IS_OVERFLOW", "#{isOverflow}");
//
//        VALUES("OP_TIME", "#{opTime}");
//        VALUES("SKILL_TYPE", "#{skillType}");
//        return SQL();
//    }
//
//}
