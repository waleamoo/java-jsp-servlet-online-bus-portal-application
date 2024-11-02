package com.techqwerty.model;

public class StudentBus {

    private int id; 
    private int studentId; 
    private int busId; 
    private int paymentId;
    private boolean isActive;

    public StudentBus() {
    }


    public StudentBus(int studentId, int busId, int paymentId, boolean isActive) {
        this.studentId = studentId;
        this.busId = busId;
        this.paymentId = paymentId;
        this.isActive = isActive;
    }


    public StudentBus(int id, int studentId, int busId, int paymentId, boolean isActive) {
        this.id = id;
        this.studentId = studentId;
        this.busId = busId;
        this.paymentId = paymentId;
        this.isActive = isActive;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBusId() {
        return this.busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }





}
