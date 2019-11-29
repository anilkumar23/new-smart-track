package com.power.smarttrack.model;


import java.util.List;

public class Current {
    private List<Double> data;
    private String label;

    public Current() {
    }

    public Current(List<Double> data, String label) {
        this.data = data;
        this.label = label;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
