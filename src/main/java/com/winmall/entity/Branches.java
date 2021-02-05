package com.winmall.entity;

public class Branches {
    private String bname;
    private String blocation;
    private String bsize;
    private String btel;

    public Branches(String bname, String blocation, String bsize, String btel) {
//        this.bname = bname;
//        this.blocation = blocation;
//        this.bsize = bsize;
//        this.btel = btel;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBlocation() {
        return blocation;
    }

    public void setBlocation(String blocation) {
        this.blocation = blocation;
    }

    public String getBsize() {
        return bsize;
    }

    public void setBsize(String bsize) {
        this.bsize = bsize;
    }

    public String getBtel() {
        return btel;
    }

    public void setBtel(String btel) {
        this.btel = btel;
    }
}
