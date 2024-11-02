package com.techqwerty.dto;

public class BusRouteDto {
	public int busId;
    public String busLabel;
    public int routeId;
	public String routePickupNumber;
    public String routeName;
    public String pickupName;
    public String dropoffName;
    public String pickupTime;
    public String dropoffTime;
    
    public BusRouteDto(int busId, String busLabel, int routeId, String routePickupNumber, String routeName,
    		String pickupName, String dropoffName, String pickupTime, String dropoffTime) {
    	super();
    	this.busId = busId;
    	this.busLabel = busLabel;
    	this.routeId = routeId;
    	this.routePickupNumber = routePickupNumber;
    	this.routeName = routeName;
    	this.pickupName = pickupName;
    	this.dropoffName = dropoffName;
    	this.pickupTime = pickupTime;
    	this.dropoffTime = dropoffTime;
    }
    
}
