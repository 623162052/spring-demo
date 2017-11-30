package com.tools.jackson.jsonproperty;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MobilePhone {

    @JsonProperty("phone_brand")
    private String brand;
    private String operationSystem;
    @JsonProperty("phone_version")
    private String version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activeDate;

    private Map<String, Object> anyAttribute = new HashMap<>();


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAny(){
        return this.anyAttribute;
    }

    @JsonAnySetter
    public void setAny(String key, Object value){
        this.anyAttribute.put(key, value);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
