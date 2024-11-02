package com.techqwerty.dto;

public class ParentStudentInsertDto {
	// parent fields
	public int parentId;
    public String parentSurname; 
    public String parentInitials;
    public String parentContactNumber; 
    public String parentEmail;
    public String parentPassword;
    // student fields 
    public String studentName;
    public String studentContactNumber;
    public String studentAddress;
    public String studentGrade;
    public int busId;
    
	public ParentStudentInsertDto(int parentId, String parentSurname, String parentInitials, String parentContactNumber,
			String parentEmail, String parentPassword, String studentName, String studentContactNumber,
			String studentAddress, String studentGrade, int busId) {
		super();
		this.parentId = parentId;
		this.parentSurname = parentSurname;
		this.parentInitials = parentInitials;
		this.parentContactNumber = parentContactNumber;
		this.parentEmail = parentEmail;
		this.parentPassword = parentPassword;
		this.studentName = studentName;
		this.studentContactNumber = studentContactNumber;
		this.studentAddress = studentAddress;
		this.studentGrade = studentGrade;
		this.busId = busId;
	}
    
    
}
