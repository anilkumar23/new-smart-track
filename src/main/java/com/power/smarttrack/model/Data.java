package com.power.smarttrack.model;

import java.util.Set;

public class Data {
    private Set<Double> data;
    private String label;

    public Data() {
    }

    public Data(Set<Double> data, String label) {
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
