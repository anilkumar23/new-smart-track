package com.power.smarttrack.repository;

import com.power.smarttrack.model.DeviceName;
import com.power.smarttrack.model.TTDPowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartTrackRepository extends JpaRepository<TTDPowerSupply, String>{
    public List<TTDPowerSupply> findByTStampContainsAndDeviceNameContaining(String tStamp, String deviceName);
    public TTDPowerSupply findByDeviceNameContaining(String subStation);

}
