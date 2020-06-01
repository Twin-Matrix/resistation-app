package com.example.registrationapp;

public class Member {

    private String Name;
    private Long Redgno;
    private int Sem;
    private String Branch;
    private String Subject;

    public Member() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getRedgno() {
        return Redgno;
    }

    public void setRedgno(Long redgno) {
        Redgno = redgno;
    }

    public int getSem() {
        return Sem;
    }

    public void setSem(int sem) {
        Sem = sem;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
