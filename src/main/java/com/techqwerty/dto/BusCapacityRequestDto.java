package com.techqwerty.dto;

public class BusCapacityRequestDto {
	public String bus_label;
	public String bus_count;
	
	public BusCapacityRequestDto(String bus_label, String bus_count) {
		super();
		this.bus_label = bus_label;
		this.bus_count = bus_count;
	}
}
