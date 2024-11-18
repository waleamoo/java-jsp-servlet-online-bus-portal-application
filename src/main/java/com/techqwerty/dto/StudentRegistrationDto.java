package com.techqwerty.dto;

public class StudentRegistrationDto {
	public int id;
	public int studentId;
	public int parentId;
	public int busId;
	public String paymentDate;
	public String paymentExpiryDate;
	public int isActive;
	
	public StudentRegistrationDto(int id, int studentId, int parentId, int busId, String paymentDate,
			String paymentExpiryDate, int isActive) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.parentId = parentId;
		this.busId = busId;
		this.paymentDate = paymentDate;
		this.paymentExpiryDate = paymentExpiryDate;
		this.isActive = isActive;
	}
	
}
