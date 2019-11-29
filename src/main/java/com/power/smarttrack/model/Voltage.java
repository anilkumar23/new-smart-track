package com.power.smarttrack.model;


import java.util.Set;

/**
 * Created by anil.saladi on 10/23/2019.
 */
public class Voltage {
    private Set<Double> data;
    private String label;

    public Voltage() {
    }

    public Voltage(Set<Double> data, String label) {
        this.data = data;
        this.label = label;
    }

    public Set<Double> getData() {
        return data;
    }

    public void setData(Set<Double> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
