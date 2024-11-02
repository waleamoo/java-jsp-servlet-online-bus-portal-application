package com.techqwerty.model;

public class Admin {
    private int adminId;
    private String adminInitials;
    private String adminSurname;
    private String adminEmail;
    private String adminPassword;

    public Admin() {
        
    }

    public Admin(String adminInitials, String adminSurname, String adminEmail, String adminPassword) {
        this.adminInitials = adminInitials;
        this.adminSurname = adminSurname;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public Admin(int adminId, String adminInitials, String adminSurname, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminInitials = adminInitials;
        this.adminSurname = adminSurname;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminInitials() {
        return this.adminInitials;
    }

    public void setAdminInitials(String adminInitials) {
        this.adminInitials = adminInitials;
    }

    public String getAdminSurname() {
        return this.adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public String getAdminEmail() {
        return this.adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return this.adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }



}
