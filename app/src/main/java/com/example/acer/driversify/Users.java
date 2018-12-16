package com.example.acer.driversify;

public class Users {
    String fname, lname, plateNum;

    public Users(String fname, String lname, String plateNum) {
        this.fname = fname;
        this.lname = lname;
        this.plateNum = plateNum;
    }

    public Users(){

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }
}
