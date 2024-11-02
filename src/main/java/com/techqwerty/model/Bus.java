package com.techqwerty.model;

public class Bus {
    private int busId;
    private String busLabel;
    private String busCapacity;
    private int busRoute;

    public Bus() {
    }


    public Bus(String busLabel, String busCapacity, int busRoute) {
        this.busLabel = busLabel;
        this.busCapacity = busCapacity;
        this.busRoute = busRoute;
    }

    public Bus(int busId, String busLabel, String busCapacity, int busRoute) {
        this.busId = busId;
        this.busLabel = busLabel;
        this.busCapacity = busCapacity;
        this.busRoute = busRoute;
    }


    public int getBusId() {
        return this.busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusLabel() {
        return this.busLabel;
    }

    public void setBusLabel(String busLabel) {
        this.busLabel = busLabel;
    }

    public String getBusCapacity() {
        return this.busCapacity;
    }

    public void setBusCapacity(String busCapacity) {
        this.busCapacity = busCapacity;
    }

    public int getBusRoute() {
        return this.busRoute;
    }

    public void setBusRoute(int busRoute) {
        this.busRoute = busRoute;
    }


    
}

