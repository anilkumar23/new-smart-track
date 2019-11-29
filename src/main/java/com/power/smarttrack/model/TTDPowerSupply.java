package com.power.smarttrack.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anil.saladi on 9/26/2019.
 */
@Entity
@Table(name = "ttdPowerSupply")
public class TTDPowerSupply implements Serializable {
    private static final long serialVersionUID = -3534650012619938612L;

    /*@Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*/
    private String id;

    private String deviceId;
    private String deviceName;
    private String tStamp;
    private String ipAddress;
    private String power;
    private String energy;
    private String subStation;

    public TTDPowerSupply(String deviceId, String deviceName, String tStamp, String ipAddress, String power, String energy, String subStation) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.tStamp = tStamp;
        this.ipAddress = ipAddress;
        this.power = power;
        this.energy = energy;
        this.subStation = subStation;
    }

    public TTDPowerSupply() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String gettStamp() {
        return tStamp;
    }

    public void settStamp(String tStamp) {
        this.tStamp = tStamp;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubStation() {
        return subStation;
    }

    public void setSubStation(String subStation) {
        this.subStation = subStation;
    }

    @Override
    public String toString() {
        return "TTDPowerSupply{" +
                "id='" + id + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", tStamp='" + tStamp + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", power='" + power + '\'' +
                ", energy='" + energy + '\'' +
                ", subStation='" + subStation + '\'' +
                '}';
    }
}
