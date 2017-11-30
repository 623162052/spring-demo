package com.tools.jackson.jsonunwrapped;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 子类
 */
public class Location {

    private double latitude;
    private double longitude;


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
