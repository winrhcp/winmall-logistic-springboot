package com.winmall.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class H2Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String userid;
    private String fname;
    private String lname;
    private String age;
    private String role;
//    @ManyToMany(mappedBy = "employees", targetEntity = H2Branches.class)
    private long branchid;

    public H2Employee(long id, String userid, String fname, String lname, String age, String role, long branchid) {
        this.id = id;
        this.userid = userid;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.role = role;
        this.branchid = branchid;
    }

    public H2Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getBranchid() {
        return branchid;
    }

    public void setBranchid(long branchid) {
        this.branchid = branchid;
    }
}
