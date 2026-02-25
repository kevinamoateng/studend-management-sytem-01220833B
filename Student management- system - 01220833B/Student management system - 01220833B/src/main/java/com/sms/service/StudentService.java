package com.sms.service;

import com.sms.domain.student;
public class StudentService {
    public void validate(student student) {

        if (!student.getStudentId().matches("[A-Za-z0-9]{4,20}"))
            throw new IllegalArgumentException("Invalid Student ID");

        if (!student.getFullName().matches("[A-Za-z ]{2,60}"))
            throw new IllegalArgumentException("Invalid Name");

        if (student.getGpa() < 0 || student.getGpa() > 4)
            throw new IllegalArgumentException("Invalid GPA");

        if (!student.getEmail().contains("@"))
            throw new IllegalArgumentException("Invalid Email");

        if (!student.getPhone().matches("\\d{10,15}"))
            throw new IllegalArgumentException("Invalid Phone");
    }

}
