package com.power.smarttrack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deviceMapping")
public class DeviceMapping {
    @Id
    private String subStation;
    private String deviceName;
    private String description;

    public DeviceMapping() {
    }

    public DeviceMapping(String subStation, String deviceName, String description) {
        this.subStation = subStation;
        this.deviceName = deviceName;
        this.description = description;
    }

    public String getSubStation() {
        return subStation;
    }

    public void setSubStation(String subStation) {
        this.subStation = subStation;
    }


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DeviceMapping{" +
                "subStation='" + subStation + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
