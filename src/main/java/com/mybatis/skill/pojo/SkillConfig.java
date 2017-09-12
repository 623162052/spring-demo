package com.mybatis.skill.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("SkillConfig")
public class SkillConfig implements Serializable {

	private long skillId;
    private String skillName;
    private String skillDesc;
    private long priorityOrder;
    private long queueMaxSize;
    private long queueTimeout;
    private String isOverflow;
    private long overflowSkill;
    private String overflowSkillName;
	private String opTime;
    private String remark1;
    private String remark2;
    private String remark3;
    private int skillType;

    public String getOverflowSkillName() {
		return overflowSkillName;
	}

	public void setOverflowSkillName(String overflowSkillName) {
		this.overflowSkillName = overflowSkillName;
	}
    public long getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(long priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public long getQueueMaxSize() {
		return queueMaxSize;
	}

	public void setQueueMaxSize(long queueMaxSize) {
		this.queueMaxSize = queueMaxSize;
	}

	public long getQueueTimeout() {
		return queueTimeout;
	}

	public void setQueueTimeout(long queueTimeout) {
		this.queueTimeout = queueTimeout;
	}

	public long getOverflowSkill() {
		return overflowSkill;
	}

	public void setOverflowSkill(long overflowSkill) {
		this.overflowSkill = overflowSkill;
	}

	public int getSkillType() {
		return skillType;
	}

	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

   

    public void setIsOverflow(String isOverflow) {
        this.isOverflow = isOverflow;
    }

    

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public long getSkillId() {
        return skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public String getIsOverflow() {
        return isOverflow;
    }

    public String getOpTime() {
        return opTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    @Override
    public String toString() {
        return "SkillConfig{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", skillDesc='" + skillDesc + '\'' +
                ", priorityOrder=" + priorityOrder +
                ", queueMaxSize=" + queueMaxSize +
                ", queueTimeout=" + queueTimeout +
                ", isOverflow='" + isOverflow + '\'' +
                ", overflowSkill=" + overflowSkill +
                ", overflowSkillName='" + overflowSkillName + '\'' +
                ", opTime='" + opTime + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", remark3='" + remark3 + '\'' +
                ", skillType=" + skillType +
                '}';
    }
}
