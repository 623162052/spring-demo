package com.tools.jackson.jsonunwrapped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 父类
 */
public class Place {

    private int placeNumber;
    private String placeName;
    @JsonUnwrapped
    private Location location;
    @JsonIgnore
    private String remark;

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
