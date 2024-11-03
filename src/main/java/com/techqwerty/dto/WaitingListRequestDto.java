package com.techqwerty.dto;

public class WaitingListRequestDto {
	public int id;
	public int studentId;
	public int busId;
	public String joinDate;
	public String paymentDate;
	public String paymentExpiryDate;
	public String studentName;
	public String studentContactNumber;
	public String parentName;
	public String parentContactNumber;
	public String parentEmail;
	
	public WaitingListRequestDto(int id, int studentId, int busId, String joinDate, String paymentDate,
			String paymentExpiryDate, String studentName, String studentContactNumber, String parentName,
			String parentContactNumber, String parentEmail) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.busId = busId;
		this.joinDate = joinDate;
		this.paymentDate = paymentDate;
		this.paymentExpiryDate = paymentExpiryDate;
		this.studentName = studentName;
		this.studentContactNumber = studentContactNumber;
		this.parentName = parentName;
		this.parentContactNumber = parentContactNumber;
		this.parentEmail = parentEmail;
	}
	
}
