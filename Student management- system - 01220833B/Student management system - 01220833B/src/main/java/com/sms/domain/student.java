package com.sms.domain;

public class student {
    private String studentId;
    private String fullName;
    private String programme;
    private int level;
    private double gpa;
    private String email;
    private String phone;
    private String status;

    public student(String studentId, String fullName, String programme,
                   int level, double gpa, String email,
                   String phone,String status) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.programme = programme;
        this.level = level;
        this.gpa = gpa;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public String getProgramme() { return programme; }
    public int getLevel() { return level; }
    public double getGpa() { return gpa; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStatus() { return status; }
}



