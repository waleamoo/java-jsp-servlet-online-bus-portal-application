package com.techqwerty.dto;

public class BusWaitingListRequestDto {
	public String studentName;
	public String studentAddress;
	public String parentName;
	public String parentEmail;
	public String parentContactNumber;
	
	public BusWaitingListRequestDto(String studentName, String studentAddress, String parentName, String parentEmail,
			String parentContactNumber) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContactNumber = parentContactNumber;
	}
	
	
	
}
