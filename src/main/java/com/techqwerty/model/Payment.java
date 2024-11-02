package com.techqwerty.model;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private int studentId;
    private int parentId;
    private LocalDate paymentDate; 
    private LocalDate paymentExpiryDate;

    public Payment() {
    }

    public Payment(int studentId, int parentId, LocalDate paymentDate, LocalDate paymentExpiryDate) {
        this.studentId = studentId;
        this.parentId = parentId;
        this.paymentDate = paymentDate;
        this.paymentExpiryDate = paymentExpiryDate;
    }


    public Payment(int paymentId, int studentId, int parentId, LocalDate paymentDate, LocalDate paymentExpiryDate) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.parentId = parentId;
        this.paymentDate = paymentDate;
        this.paymentExpiryDate = paymentExpiryDate;
    }


    public int getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getPaymentExpiryDate() {
        return this.paymentExpiryDate;
    }

    public void setPaymentExpiryDate(LocalDate paymentExpiryDate) {
        this.paymentExpiryDate = paymentExpiryDate;
    }




}
