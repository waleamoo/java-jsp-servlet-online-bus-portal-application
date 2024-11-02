package com.techqwerty.model;

public class Parent {
    private int parentId;
    private String parentSurname; 
    private String parentInitials;
    private String parentContactNumber; 
    private String parentEmail;
    private String parentPassword;

    public Parent() {
    }


    public Parent(String parentSurname, String parentInitials, String parentContactNumber, String parentEmail, String parentPassword) {
        this.parentSurname = parentSurname;
        this.parentInitials = parentInitials;
        this.parentContactNumber = parentContactNumber;
        this.parentEmail = parentEmail;
        this.parentPassword = parentPassword;
    }

    public Parent(int parentId, String parentSurname, String parentInitials, String parentContactNumber, String parentEmail, String parentPassword) {
        this.parentId = parentId;
        this.parentSurname = parentSurname;
        this.parentInitials = parentInitials;
        this.parentContactNumber = parentContactNumber;
        this.parentEmail = parentEmail;
        this.parentPassword = parentPassword;
    }


    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentSurname() {
        return this.parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParentInitials() {
        return this.parentInitials;
    }

    public void setParentInitials(String parentInitials) {
        this.parentInitials = parentInitials;
    }

    public String getParentContactNumber() {
        return this.parentContactNumber;
    }

    public void setParentContactNumber(String parentContactNumber) {
        this.parentContactNumber = parentContactNumber;
    }

    public String getParentEmail() {
        return this.parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentPassword() {
        return this.parentPassword;
    }

    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
    }


}
