package com.winmall.entities;

import javax.persistence.*;

@Entity
@Table(name = "branch")
public class H2Branches {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    private String bname;
    private String blocation;
    private String bsize;
    private String btel;

    public H2Branches(long id, String bname, String blocation, String bsize, String btel) {
        this.id = id;
        this.bname = bname;
        this.blocation = blocation;
        this.bsize = bsize;
        this.btel = btel;
    }

    public H2Branches() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
