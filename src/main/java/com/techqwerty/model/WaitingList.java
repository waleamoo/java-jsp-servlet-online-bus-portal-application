package com.techqwerty.model;

import java.time.LocalDate;

public class WaitingList {

    private int id; 
    private int studentId; 
    private int busId; 
    private LocalDate joinDate;

    public WaitingList() {
    }


    public WaitingList(int studentId, int busId, LocalDate joinDate) {
        this.studentId = studentId;
        this.busId = busId;
        this.joinDate = joinDate;
    }


    public WaitingList(int id, int studentId, int busId, LocalDate joinDate) {
        this.id = id;
        this.studentId = studentId;
        this.busId = busId;
        this.joinDate = joinDate;
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

    public LocalDate getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    


}
