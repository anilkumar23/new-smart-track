package com.power.smarttrack.service;

import com.power.smarttrack.model.*;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    public boolean insertData(List<TTDPowerSupply> ttdPowerSupplies);
    public DeviceVariables getVoltageData(SmartTrackRequest smartTrackRequest);
    public List<TTDPowerSupply> getDeviceDataWithName(String deviceName);
    public DeviceName getDeviceNames(String subStation);
}
