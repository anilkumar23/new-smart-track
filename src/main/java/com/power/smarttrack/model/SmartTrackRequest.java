package com.power.smarttrack.model;

/**
 * Created by anil.saladi on 9/29/2019.
 */

public class SmartTrackRequest {

    private String timestamp;
    private String deviceName;

    public SmartTrackRequest() {
    }

    public SmartTrackRequest(String timestamp, String deviceName) {
        this.timestamp = timestamp;
        this.deviceName = deviceName;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
