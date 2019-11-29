package com.power.smarttrack.model;



import java.util.Set;

public class DeviceVariables {
    private Set<Voltage> voltage;
    private Set<Current> current;
    private Set<PowerFactor> powerFactor;

    public DeviceVariables() {
    }

    public DeviceVariables(Set<Voltage> voltage, Set<Current> current, Set<PowerFactor> powerFactor) {
        this.voltage = voltage;
        this.current = current;
        this.powerFactor = powerFactor;
    }


    public Set<Voltage> getVoltage() {
        return voltage;
    }

    public void setVoltage(Set<Voltage> voltage) {
        this.voltage = voltage;
    }

    public Set<Current> getCurrent() {
        return current;
    }

    public void setCurrent(Set<Current> current) {
        this.current = current;
    }

    public Set<PowerFactor> getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Set<PowerFactor> powerFactor) {
        this.powerFactor = powerFactor;
    }
}
