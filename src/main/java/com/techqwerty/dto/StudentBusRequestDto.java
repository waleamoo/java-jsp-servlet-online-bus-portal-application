package com.techqwerty.dto;

public class StudentBusRequestDto {
	public int studentId;
    public String studentName;
    public String studentContactNumber;
    public String studentAddress;
    public String studentGrade;
    public int parentId; 
    public int busId;
    public String paymentDate;
    public String paymentExpiryDate;
    
	public StudentBusRequestDto(int studentId, String studentName, String studentContactNumber, String studentAddress,
			String studentGrade, int parentId, int busId, String paymentDate, String paymentExpiryDate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentContactNumber = studentContactNumber;
		this.studentAddress = studentAddress;
		this.studentGrade = studentGrade;
		this.parentId = parentId;
		this.busId = busId;
		this.paymentDate = paymentDate;
		this.paymentExpiryDate = paymentExpiryDate;
	}
}
