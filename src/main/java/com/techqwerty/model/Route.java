package com.techqwerty.model;

import java.time.LocalTime;

public class Route {
    private int routeId;
    private String routePickupNumber;
    private String routeName;
    private String pickupName;
    private LocalTime pickupTime;
    private String dropOffName;
    private LocalTime dropOffTime;

    public Route() {
    }


    public Route(String routePickupNumber, String routeName, String pickupName, LocalTime pickupTime, String dropOffName, LocalTime dropOffTime) {
        this.routePickupNumber = routePickupNumber;
        this.routeName = routeName;
        this.pickupName = pickupName;
        this.pickupTime = pickupTime;
        this.dropOffName = dropOffName;
        this.dropOffTime = dropOffTime;
    }


    public Route(int routeId, String routePickupNumber, String routeName, String pickupName, LocalTime pickupTime, String dropOffName, LocalTime dropOffTime) {
        this.routeId = routeId;
        this.routePickupNumber = routePickupNumber;
        this.routeName = routeName;
        this.pickupName = pickupName;
        this.pickupTime = pickupTime;
        this.dropOffName = dropOffName;
        this.dropOffTime = dropOffTime;
    }


    public int getRouteId() {
        return this.routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRoutePickupNumber() {
        return this.routePickupNumber;
    }

    public void setRoutePickupNumber(String routePickupNumber) {
        this.routePickupNumber = routePickupNumber;
    }

    public String getRouteName() {
        return this.routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getPickupName() {
        return this.pickupName;
    }

    public void setPickupName(String pickupName) {
        this.pickupName = pickupName;
    }

    public LocalTime getPickupTime() {
        return this.pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDropOffName() {
        return this.dropOffName;
    }

    public void setDropOffName(String dropOffName) {
        this.dropOffName = dropOffName;
    }

    public LocalTime getDropOffTime() {
        return this.dropOffTime;
    }

    public void setDropOffTime(LocalTime dropOffTime) {
        this.dropOffTime = dropOffTime;
    }






}
