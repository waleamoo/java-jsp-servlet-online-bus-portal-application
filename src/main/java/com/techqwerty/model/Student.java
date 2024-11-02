package com.techqwerty.model;

public class Student {
    private int studentId;
    private String studentName;
    private String studentContactNumber;
    private String studentAddress;
    private String studentGrade;
    private int parentId; 


    public Student() {
    }


    public Student(String studentName, String studentContactNumber, String studentAddress, String studentGrade, int parentId) {
        this.studentName = studentName;
        this.studentContactNumber = studentContactNumber;
        this.studentAddress = studentAddress;
        this.studentGrade = studentGrade;
        this.parentId = parentId;
    }


    public Student(int studentId, String studentName, String studentContactNumber, String studentAddress, String studentGrade, int parentId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentContactNumber = studentContactNumber;
        this.studentAddress = studentAddress;
        this.studentGrade = studentGrade;
        this.parentId = parentId;
    }


    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContactNumber() {
        return this.studentContactNumber;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }

    public String getStudentAddress() {
        return this.studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentGrade() {
        return this.studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }




}
