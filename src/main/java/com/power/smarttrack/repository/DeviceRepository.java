package com.power.smarttrack.repository;

import com.power.smarttrack.model.DeviceMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceMapping , String> {
}
