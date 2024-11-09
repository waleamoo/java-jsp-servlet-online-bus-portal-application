package com.techqwerty.dto;

public class StudentInsertDto {
	public String studentName;
    public String studentContactNumber;
    public String studentAddress;
    public String studentGrade;
    public int parentId;
    public int busId;
    
	public StudentInsertDto(String studentName, String studentContactNumber, String studentAddress, String studentGrade,
			int parentId, int busId) {
		super();
		this.studentName = studentName;
		this.studentContactNumber = studentContactNumber;
		this.studentAddress = studentAddress;
		this.studentGrade = studentGrade;
		this.parentId = parentId;
		this.busId = busId;
	}
    
    
}
